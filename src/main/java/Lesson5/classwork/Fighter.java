package Lesson5.classwork;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Fighter implements Runnable {

    private static int counter = 0;
    private final String name;
    private int hp = (int) (100 + Math.random() * 100);
    private final int damage = (int) (1 + Math.random() * 100);
    private Fighter enemy;
    private final Semaphore semaphore;

    public Fighter(Semaphore semaphore) {
        counter++;
        name = "Fighter" + counter;
        this.semaphore = semaphore;
    }

    public void setEnemy(Fighter enemy) {
        this.enemy = enemy;
    }

    public void fight(Fighter fighter) throws InterruptedException {
        semaphore.acquire();
        if(hp <= 0 || fighter.hp <= 0) {
            return;
        }
        while(true) {
            fighter.hp -= damage;
            System.out.println(name + " hit " + fighter.name + " " +
                    "to " + damage + " points");
            TimeUnit.MILLISECONDS.sleep(500);
            if(fighter.hp <= 0) {
                System.out.println(name + " kill " + fighter.name);
                break;
            }
            hp -= fighter.damage;
            System.out.println(fighter.name + " hit " + name + " " +
                    "to " + fighter.damage + " points");
            TimeUnit.MILLISECONDS.sleep(500);
            if(fighter.hp <= 0) {
                System.out.println(fighter.name + " kill " + name);
                break;
            }
        }
        semaphore.release();
    }

    @SneakyThrows
    @Override
    public void run() {
        fight(enemy);
    }
}
