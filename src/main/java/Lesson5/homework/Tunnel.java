package Lesson5.homework;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    Semaphore smp = new Semaphore(2);

    public Tunnel() {
        this.length = 80;
        this.description = "Tunnel " + length + " metres";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                smp.acquire();
                System.out.println(c.getName() + " preparing(waiting): " + description);
                System.out.println(c.getName() + " start stage: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " finish stage: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}