package Lesson7;

import lombok.SneakyThrows;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DBCore {

    private static final Logger LOG = LoggerFactory.getLogger(DBCore.class);
    private Statement statement;
    private Connection connection;

    @SneakyThrows
    public DBCore() {
        List<String> classNames = Files.list(Path.of("src/main/java/Lesson7"))
                .map(p -> "Lesson7." + p.getFileName().toString().replace(".java", ""))
                .collect(Collectors.toList());
        for (String className : classNames) {
            Class<?> clazz = Class.forName(className);
            if(clazz.isAnnotationPresent(DBTable.class)) {
                createTable(clazz);
            }
        }
    }

    @SneakyThrows
    private void open() {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:geekbrainsDB");
        statement = connection.createStatement();
    }

    @SneakyThrows
    private void close() {
        statement.close();
        connection.close();
    }

    @SneakyThrows
    public void createTable(Class<?> clazz) {
        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        open();
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS ");
        sql.append(clazz.getSimpleName().toUpperCase());
        sql.append("(");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(DBField.class)) {
                String dbColumnName = field.getName().toUpperCase();
                String dbDataType = field.getAnnotation(DBField.class).type();
                sql.append(dbColumnName).append(' ').append(dbDataType).append(", ");
            }
        }
        sql.delete(sql.length() - 2, sql.length()).append(");");
        LOG.debug("generated query: {}", sql);
        statement.execute(sql.toString());
        close();
    }

    @SneakyThrows
    public void insert(Object o) {
        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        open();
        Class<?> clazz = o.getClass();
        String tableName = clazz.getSimpleName().toUpperCase();
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(tableName).append(" VALUES(");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(DBField.class)) {
                field.setAccessible(true);
                Object value = field.get(o);
                if(value instanceof String) {
                    value = "'" + value + "'";
                }
                sql.append(value).append(' ').append(", ");
            }
        }
        sql.delete(sql.length() - 2, sql.length()).append(");");
        LOG.debug("generated query: {}", sql);
        statement.execute(sql.toString());
        close();
    }
}
