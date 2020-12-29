package Lesson4;

import java.util.concurrent.TimeUnit;

public class CustomThread extends Thread {

    private static volatile int incrementor;
    private boolean running;
    private int counter;

    @Override
    public void run() {
        running = true;
        while(running) {
            counter++;
            synchronized (CustomThread.class) {
                incrementor++;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
