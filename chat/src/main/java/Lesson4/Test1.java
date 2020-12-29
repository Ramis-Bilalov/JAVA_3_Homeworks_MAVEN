package Lesson4;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        CustomThread[] threads = new CustomThread[40];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new CustomThread();
            threads[i].setPriority(1);
            if(i == 39) {
                threads[i].setPriority(10);
            }
            threads[i].setDaemon(true);
            threads[i].start();
        }
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String command = in.next();
            if(command.equals("counter")) {
                long sum = 0;
                for (CustomThread thread : threads) {
                    int counter = thread.getCounter();
                    System.out.println(thread.getName() +
                            "'s counter " + counter);
                    sum += counter;
                }
                System.out.println("Incrementor: " + CustomThread.getIncrementor() + "' counters sum: " + sum);
            }
            if(command.equals("inc")) {
                System.out.println("Incrementor: " + CustomThread.getIncrementor());
            }
            if(command.equals("info")) {
                System.out.println("Thread info: ");
                Thread.currentThread().getThreadGroup().list();
            }
        }
    }
}
