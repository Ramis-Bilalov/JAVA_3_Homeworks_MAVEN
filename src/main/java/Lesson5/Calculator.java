package Lesson5;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Calculator implements Runnable {


    private Integer counter;
    private int limit = 100;
    private final Lock lock;

    public Calculator(Integer counter, Lock lock) {
        this.lock = lock;
        this.counter = counter;
    }

    public void calc() {
        lock.lock();
        counter++;
        if(counter > limit) {
            counter = 0;
            lock.unlock();
            hardCalculation();
        } else {
            lock.unlock();
        }
    }

    private void hardCalculation() {
        int x = 0;
        System.out.println(this + " start hard");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            x += x * 10;
        }
        System.out.println(this + " finish hard");
    }

    @SneakyThrows
    @Override
    public void run() {
        while(true) {
            calc();
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }
}
