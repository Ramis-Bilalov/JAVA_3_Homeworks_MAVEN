package Lesson1.homework_3;

public class Test {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange());
        Box<Apple> secondAppleBox = new Box<>();

        appleBox.addFruit(new Apple());

        orangeBox.addFruit(new Orange());

        System.out.println("Вес appleBox: " + appleBox.getWeight());
        System.out.println("Вес orangeBox: " + orangeBox.getWeight());
        System.out.println("Вес secondAppleBox: " + secondAppleBox.getWeight());

        System.out.println("Сравнение appleBox и orangeBox: " + appleBox.compare(orangeBox));

        appleBox.transferToNewBox(secondAppleBox);

        System.out.println("Вес appleBox после трансфера: " + appleBox.getWeight());
        System.out.println("Вес orangeBox после трансфера: " + orangeBox.getWeight());
        System.out.println("Вес secondAppleBox после трансфера: " + secondAppleBox.getWeight());
    }
}
