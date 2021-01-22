package Lesson6.homework;

public class MainClass {
    public static void main(String[] args) {
        HomeworkClass hw = new HomeworkClass();
        int[] array = {1, 1, 2, 3, 1, 5, 4, 7, 4, 9, 2};
        hw.getNewArray(array);
        System.out.println("Наличие в массиве значений 1 и 4: " + hw.checkArray(array));
    }
}
