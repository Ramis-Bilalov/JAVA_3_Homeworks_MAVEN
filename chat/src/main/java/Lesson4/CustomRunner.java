package Lesson4;

import lombok.SneakyThrows;
import java.util.concurrent.TimeUnit;

public class CustomRunner implements Runnable {

    private static volatile int currentNumber = 0;
    private volatile int number;
    private final Object monitor;
    private String s;

    public CustomRunner(int number,
                        Object monitor,
                        String s) {
        this.number = number;
        this.monitor = monitor;
        this.s = s;
    }

    @SneakyThrows
    @Override
    public void run() {
        while(true) {
            synchronized (monitor) {
                if(currentNumber != number) {
                    monitor.wait();
                } else {
                    currentNumber = (currentNumber + 1) % 2;
                    monitor.notify();
                    System.out.print(s);
                    TimeUnit.MILLISECONDS.sleep(300);
                }
            }
        }
    }
}
