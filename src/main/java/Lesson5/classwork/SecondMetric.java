package Lesson5.classwork;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class SecondMetric implements RPSInfo {

    private ConcurrentLinkedDeque<AtomicLong> deque;

    public SecondMetric() {
        deque = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 100; i++) {
            deque.add(new AtomicLong(0));
        }
        new Thread (() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                    deque.removeLast();
                    deque.addFirst(new AtomicLong(0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void inc() {
        deque.getFirst().incrementAndGet();
    }

    public boolean allow() {
        return getRPS() < 1000;
    }

    @Override
    public long getRPS() {
        long sum = 0;
        for (AtomicLong atomicLong : deque) {
            sum += atomicLong.get();
        }
        return sum;
    }
}
