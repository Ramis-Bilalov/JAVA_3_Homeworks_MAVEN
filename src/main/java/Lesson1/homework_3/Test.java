package Lesson1.homework_3;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();
        Apple apple = new Apple();
        Orange orange = new Orange();

        box1.addFruit(apple);
        box1.addFruit(apple);
        box1.addFruit(apple);
        box1.addFruit(apple);
        box1.addFruit(apple);
        box1.addFruit(orange);
        box1.addFruit(orange);

        box2.addFruit(apple);
        box2.addFruit(apple);
        box2.addFruit(apple);
        box2.addFruit(orange);
        box2.addFruit(orange);

        int fruitCount = box1.getAppleCounter();
        System.out.println("Количество яблок в коробке box1: " + fruitCount);
        fruitCount = box1.getOrangeCounter();
        System.out.println("Количество апельсинов в коробке box1: " + fruitCount);

        System.out.println();

        fruitCount = box2.getAppleCounter();
        System.out.println("Количество яблок в коробке box2: " + fruitCount);
        fruitCount = box2.getOrangeCounter();
        System.out.println("Количество апельсинов в коробке box: " + fruitCount);

        System.out.println();

        double boxWeight = box1.getBoxWeight(apple, orange);
        System.out.println("Вес коробки box1: " + boxWeight);
        boxWeight = box2.getBoxWeight(apple, orange);
        System.out.println("Вес коробки box2: " + boxWeight);

        System.out.println();

        boolean bool = box1.compareBoxesWeight(box2);
        System.out.println("Сравнение box1 и box2 по весу: " + bool);

        ArrayList<Object> newBox = box1.addToAnotherBox(box1.getAppleBox(), apple);
        System.out.println("Содержание newBox: " + newBox);
        System.out.println("Коробка box1, с которой высыпали фрукты: " + box1.getAppleBox());
    }
}
