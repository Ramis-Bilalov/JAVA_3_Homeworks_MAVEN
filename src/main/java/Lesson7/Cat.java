package Lesson7;

@DBTable
public class Cat {

    @DBField(type = "INTEGER")
    private long id;
    @DBField(type = "INTEGER")
    private int age;
    @DBField(type = "TEXT")
    private String name;
    @DBField(type = "TEXT")
    private String color;
}
