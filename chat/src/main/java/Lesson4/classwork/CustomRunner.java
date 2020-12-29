package Lesson4.classwork;

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

    @Override
    public void run() {
        while(true) {
            synchronized (monitor) {
                if(currentNumber != number) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    currentNumber = (currentNumber + 1) % 2;
                    monitor.notify();
                    System.out.print(s);
                    try {
                        TimeUnit.MILLISECONDS.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
