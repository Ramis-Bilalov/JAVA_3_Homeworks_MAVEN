package Lesson4.homework;

import lombok.SneakyThrows;
import java.util.concurrent.TimeUnit;

public class ABCRunner implements Runnable {

    private static volatile int currentNumber = 0;
    private static int counter;
    private final int number;
    private final Object monitor;
    private final String s;

    public ABCRunner(int number,
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
                    currentNumber = (currentNumber + 1) % 3;
                    if(currentNumber == 1) {
                        System.out.print("_");
                        counter++;
                    }
                    monitor.notifyAll();
                    System.out.print(s);
                    if(counter == 5) break;
                    TimeUnit.MILLISECONDS.sleep(30);
                }
            }
        }
    }
}
