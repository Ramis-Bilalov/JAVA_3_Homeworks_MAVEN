package Lesson6.homework;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HomeworkClassTest {

    HomeworkClass homeworkClass = new HomeworkClass();

    @Test
    public void getNewArray() {
        int[] array1 = {1, 1, 2, 3, 1, 5, 4, 7, 8, 9, 2};
        List<Integer> listArray1 = homeworkClass.getNewArray(array1);
        List<Integer> newArray1 = new ArrayList<>();
        newArray1.add(7);
        newArray1.add(8);
        newArray1.add(9);
        newArray1.add(2);
        Assert.assertEquals(newArray1, listArray1);

        homeworkClass.clearArray();

        int[] array2 = {1, 2, 2, 4, 1, 5, 4, 7, 4, 9, 2};
        List<Integer> listArray2 = homeworkClass.getNewArray(array2);
        List<Integer> newArray2 = new ArrayList<>();
        newArray2.add(9);
        newArray2.add(2);
        Assert.assertEquals(newArray2, listArray2);
    }

    @Test
    public void checkArray() {
        int[] array1 = {1, 1, 2, 3, 1, 5, 4, 7, 8, 9, 2};
        boolean actual1 = homeworkClass.checkArray(array1);
        boolean expected1 = true;
        Assert.assertEquals(expected1, actual1);

        int[] array2 = {2, 1, 2, 3, 2, 5, 5, 9, 8, 9, 2};
        boolean actual2 = homeworkClass.checkArray(array2);
        boolean expected2 = true;
        Assert.assertEquals(expected2, actual2);
    }
}