package Lesson1.homework_3;

import java.util.ArrayList;

public class Box {

    private final ArrayList<Object> orangeBox;
    private final ArrayList<Object> appleBox;
    private final ArrayList<Object> newBox;
    private int appleCounter;
    private int orangeCounter;
    private float weight;
    private double allWeight;
    private final float appleWeight = 1f;
    private final float orangeWeight = 1.5f;

    public Box() {
        orangeBox = new ArrayList<>();
        appleBox = new ArrayList<>();
        newBox = new ArrayList<>();
    }

    public double getWeight(Object objects) {
        if(objects.getClass().getSimpleName().contains("Apple")) {
            weight = appleCounter * appleWeight;
        } else if(objects.getClass().getSimpleName().contains("Orange")) {
            weight = orangeCounter * orangeWeight;
        } return weight;
    }

    public double getBoxWeight(Object object1, Object object2) {
        allWeight = getWeight(object1) + getWeight(object2);
        return allWeight;
    }

    public int getAppleCounter() {
        return appleCounter;
    }

    public int getOrangeCounter() {
        return orangeCounter;
    }

    public ArrayList<Object> getOrangeBox() {
        return orangeBox;
    }

    public ArrayList<Object> getAppleBox() {
        return appleBox;
    }

    public boolean compareBoxesWeight(Box box) {
        if(this.allWeight == box.allWeight) {
            return true;
        } return false;
    }

    public ArrayList<Object> addToAnotherBox(ArrayList<Object> arrayList, Object object) {
        if(arrayList.contains(object)) {
            newBox.addAll(arrayList);
            arrayList.clear();
        } return newBox;
    }

    public void addFruit(Object object) {
        if(object.getClass().getSimpleName().contains("Apple")) {
            appleBox.add(object);
            appleCounter++;
        } else if(object.getClass().getSimpleName().contains("Orange")) {
            orangeBox.add(object);
            orangeCounter++;
        }
    }
}
