package Lesson7;

@DBTable
public class User {

    @DBField(type = "INTEGER")
    private int id;

    @DBField(type = "TEXT")
    private String name;

    @DBField(type = "TEXT")
    private String surname;


    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
