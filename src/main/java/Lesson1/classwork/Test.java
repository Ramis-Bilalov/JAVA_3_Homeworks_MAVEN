package Lesson1.classwork;

public class Test {

    static <T> T getT(T value) {
        return value;
    }

    static <R, T> R map(R value, T out) {
        return null;
    }

    public static void main(String[] args) {
        MyArray array = new MyArray();
        array.add(12);
        array.add("12314");
        array.add(null);
        int value = (int) array.get(0);
        int value1 = (int) array.get(1);
        System.out.println(value);

        MyArrayGen<Integer> arrayGen = new MyArrayGen<>();
        arrayGen.add(12);
    }
}
