package Lesson5;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Initer implements Runnable {

    private final int sleepTime = 1 + (int) (Math.random() * 5000);
    private final CountDownLatch cl;

    public Initer(CountDownLatch cl) {
        this.cl = cl;
    }

    @SneakyThrows
    void init() {
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        System.out.println(this + " sleep " + sleepTime + " ms.");
        cl.countDown();
    }

    void doJob() {
        System.out.println(this + " hello world!");
    }

    @SneakyThrows
    @Override
    public void run() {
        init();
        cl.await();
        doJob();
    }
}
