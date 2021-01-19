package Lesson5.homework;

import lombok.SneakyThrows;

public class Road extends Stage {

    private int counter = 0;
    private int counterf = 0;

    public Road(int length) {
        this.length = length;
        this.description = "Road " + length + " metres";
    }
    @SneakyThrows
    @Override
    public void go(Car c) {
        counter++;
        if(length == 40) {
            counterf++;
        }
        if(length == 60 && counter == 4) {
            System.out.println("IMPORTANT ANNOUNCEMENT >>> Race is started!!!");
        }
        System.out.println(c.getName() + " start stage: " + description);

        Thread.sleep(length / c.getSpeed() * 1000);
        System.out.println(c.getName() + " finish stage: " + description);

        counter = 0;
        if(counterf == 4) {
            System.out.println("IMPORTANT ANNOUNCEMENT >>> Race is finished!!!");
        }
    }
}
