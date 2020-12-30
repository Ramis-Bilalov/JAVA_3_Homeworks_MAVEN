package Lesson4.homework;

public class Test {
    public static void main(String[] args) {
        Object mon = new Object();
        Thread t1 = new Thread(new ABCRunner(
                0, mon, "A"));
        Thread t2 = new Thread(new ABCRunner(
                2, mon, "C"));
        Thread t3 = new Thread(new ABCRunner(
                1, mon, "B"));
        t1.start();
        t2.start();
        t3.start();
    }
}
