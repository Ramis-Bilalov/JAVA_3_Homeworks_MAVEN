package Lesson4.classwork;


import lombok.SneakyThrows;
import java.util.concurrent.TimeUnit;

public class CustomThread extends Thread {

    // WaitSet
    // EntryList
    // incrementor = sum(counters)
    // -
    //  -
    // -
    // -

    private static volatile int incrementor;

    private boolean running;
    private int counter;

    @SneakyThrows
    @Override
    public void run() {
        running = true;
        while (running) {
            counter++;
            synchronized (CustomThread.class) {
                incrementor++;
            }
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }

    public int getCounter() {
        return counter;
    }

    public static int getIncrementor() {
        return incrementor;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}