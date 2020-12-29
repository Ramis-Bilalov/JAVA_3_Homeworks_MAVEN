package Lesson4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test3 {

    static String s = "str";

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Object mon = new Object();
        //executor.execute(new ClientHandler());
        for (int i = 0; i < 100; i++) {
            executor.execute(new CustomRunnerAlt(i, mon, s + i));
        }
        executor.shutdownNow();
    }
}