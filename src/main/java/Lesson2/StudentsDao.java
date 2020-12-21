package Lesson2;

import java.sql.SQLException;

public interface StudentsDao {

    boolean studentExists(int id) throws SQLException;

    Student getStudentById(int id) throws SQLException;

    void updateStudent(Student student) throws SQLException;
}
