package Lesson2;

import java.io.Closeable;
import java.sql.SQLException;

public interface StudentsDao extends Closeable {

    boolean studentExists(int id) throws SQLException;

    Student getStudentById(int id) throws SQLException;

    void updateStudent(Student student) throws SQLException;
}
