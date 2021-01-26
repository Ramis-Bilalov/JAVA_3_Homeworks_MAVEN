package Lesson7.homework;

import lombok.SneakyThrows;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.TreeSet;

public class TestClazz {

    Clazz clazz = new Clazz();

    @BeforeSuite
    public void startTest() {
        System.out.println("*-*-Test is started");
    }

    @AfterSuite
    public void finishTest() {
        System.out.println("*-*-Test is finished");
    }

    @Tester(priority = 1)
    public void multiply() {
        int result = clazz.multiply(5,5);
        int expected = 25;
        if(expected == result) {
            System.out.println("Result of multiply: " + result);
        }
    }

    @Tester(priority = 6)
    public void division() {
        int result = clazz.division(5,5);
        int expected = 1;
        if(expected == result) {
            System.out.println("Result of division: " + result);
        }
    }

    @SneakyThrows
    public void start(Class<?> clazz) {
        startTest();
        int count = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> sortedArrayList = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Method[] methods = clazz.getDeclaredMethods();
        ArrayList<Method> testMethods = new ArrayList<>();
        ArrayList<Method> testMethods1 = new ArrayList<>();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Tester.class)) {
                method.invoke(this);
            }
        }
        finishTest();
    }
}
