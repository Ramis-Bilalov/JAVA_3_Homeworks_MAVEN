package Lesson5.homework;

import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    Semaphore smp = new Semaphore(4);

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Participant #" + CARS_COUNT;
    }

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        System.out.println(this.name + " preparing");
        try {
            smp.acquire();
            System.out.println(this.name + " ready");
            smp.release();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

    }
}
