package Lesson6.homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkClass {

    private List<Integer> newArray = new ArrayList<>();

    public List<Integer> getNewArray(int[] array) {
        int counter = 0;
        int point = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                counter++;
                point = i;
            }
        }
        if(counter == 0) {
            throw new RuntimeException();
        }
        for (int i = point + 1; i < array.length; i++) {
            newArray.add(array[i]);
        }
        return newArray;
    }

    public void clearArray() {
        newArray.clear();
    }

    public boolean checkArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1 || array[i] == 4) {
                return true;
            }
        }
        return false;
    }
}