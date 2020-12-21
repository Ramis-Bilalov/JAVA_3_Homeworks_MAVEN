package Lesson2;

import java.time.LocalDate;
import java.util.Objects;

public class Student {

    private int id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private int group;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Student(String name, String surname, LocalDate birthDate, int group) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getGroup() == student.getGroup()
                && getName().equals(student.getName())
                && getSurname().equals(student.getSurname())
                && getBirthDate().equals(student.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getName(),
                getSurname(),
                getBirthDate(),
                getGroup());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", group=" + group +
                '}';
    }
}
