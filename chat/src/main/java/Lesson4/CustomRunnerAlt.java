package Lesson4;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class CustomRunnerAlt implements Runnable {

    private static volatile int currentNumber = 0;
    private final Object monitor;
    private volatile int number;
    private String s;

    public CustomRunnerAlt(int number,
                        Object monitor,
                        String s) {
        this.number = number;
        this.monitor = monitor;
        this.s = s;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            System.out.print(s);
            //TimeUnit.MILLISECONDS.sleep(300);

//            if (currentNumber != number) {
//                synchronized (monitor) {
//                    monitor.wait();
//                /}
//            } else {
//                System.out.print(s);
//                synchronized (monitor) {
//                    currentNumber = (currentNumber + 1) % 2;
//                    monitor.notify();
//                    TimeUnit.MILLISECONDS.sleep(300);
//                }
//            }

        }
    }


}