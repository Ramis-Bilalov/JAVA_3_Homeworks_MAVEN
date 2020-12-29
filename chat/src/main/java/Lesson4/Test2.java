package Lesson4;

public class Test2 {

    static void f1() {
        long start = System.currentTimeMillis();
        for (long i = 0; i < 10_000_000_000L; i++) {

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    static void f2() {
        long start = System.currentTimeMillis();
        long x = 0;
        for (long i = 0; i < 10_000_000_000L; i++) {
            x = (x + x * i) * (i - 1);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        Object mon = new Object();
        Thread t1 = new Thread(new CustomRunner(
                0, mon, "["));
        Thread t2 = new Thread(new CustomRunner(
                1, mon, "]"));
        t1.start();
        t2.start();
    }
}
