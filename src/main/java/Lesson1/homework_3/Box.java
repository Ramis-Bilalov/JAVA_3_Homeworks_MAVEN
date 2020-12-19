package Lesson1.homework_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruitBox;

    public Box() {
        fruitBox = new ArrayList<>();
    }

    @SafeVarargs
    public Box(T... fruits) {
        this.fruitBox = new ArrayList<>(Arrays.asList(fruits));
    }

    public float getWeight() {
        float weight = 0.0f;
        for(T fruit: fruitBox) {
            weight = weight + fruit.getFruitWeight();
        }
        return weight;
    }

    public boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }

    public void transferToNewBox(Box<T> box2) {
        box2.fruitBox.addAll(fruitBox);
        System.out.println("трансфер");
        fruitBox.clear();
    }

    public void addFruit(T fruit) {
        fruitBox.add(fruit);
    }
}
