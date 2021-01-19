package Lesson2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class StudentsDaoTest {

    StudentsDao studentsDao;

    @Before
    public void before() throws SQLException, ClassNotFoundException {
        studentsDao = new StudentsSQLiteDao();

    }

    @After
    public void after() throws IOException {
        studentsDao.close();
    }

    @Test
    public void studentExists() throws SQLException {
        boolean actual = studentsDao.studentExists(1);
        Assert.assertTrue(actual);
    }

    @Test
    public void getStudentById() throws SQLException {
        Student student = studentsDao.getStudentById(1);
        String actual = student.toString();
        String expected = "Student{id=1, name='IVANOV', surname='IVAN', birthDate=1970-01-01, group=0}";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateStudent() throws SQLException {
        Student student = new Student("IVANOV", "IVAN", LocalDate.of(1990, 1, 1), 1);
        studentsDao.updateStudent(student);
        student = studentsDao.getStudentById(2);
        String actual = student.toString();
        String expected = "Student{id=2, name='PETROV', surname='PETR', birthDate=1970-01-01, group=0}";
        Assert.assertEquals(expected, actual);
    }
}