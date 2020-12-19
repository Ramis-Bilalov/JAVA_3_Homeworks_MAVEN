package Lesson1.homework_1_2;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayGen {
    private Number[] data;
    private int size, capacity;
    private ArrayList<Number> arrayList;

    public ArrayGen() {
        size = 0;
        capacity = 128;
        data = new Number[capacity];
        arrayList = new ArrayList<>();
    }

    public ArrayList<Number> getArrayList() {
        return arrayList;
    }

    public Object get(int index) {
        return data[index];
    }

    public void set(int index, Number o) {
        data[index] = o;
    }

    public void add(Number o) {
        data[size] = o;
        size++;
    }

    public void changeElementPosOnArr(int firstIndex, int secondIndex) {        // 1.
        Number o = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = o;
    }

    public void convertArrToArrList() {                                         // 2.
        arrayList.addAll(Arrays.asList(data).subList(0, size));
    }


    public void remove() {
        size--;
    }
}
