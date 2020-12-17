package Lesson1.homework_1_2;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayGen arrayGen = new ArrayGen();
        arrayGen.add(1);
        arrayGen.add(2);
        arrayGen.add(3);
        arrayGen.add(4);
        arrayGen.add(5);
        arrayGen.add(6);
        arrayGen.add(7);

        arrayGen.changeElementPosOnArr(0, 5);
        System.out.println(arrayGen.get(5));

        arrayGen.convertArrToArrList();
        System.out.println(arrayGen.getArrayList());


    }
}
