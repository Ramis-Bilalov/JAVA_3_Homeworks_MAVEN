package Lesson7;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        ReflectionUtils.printClassInfo(String.class);
//        String s = "123";
//        ReflectionUtils.set(s, new byte[]{65, 66}, "value");
//        System.out.println(s);
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//        ReflectionUtils.set(list, 2, "size");
//        list.add(11);
//        System.out.println(list);
////        ReflectionUtils.printClassInfo(ArrayList.class, "M");
//        System.out.println(
//                Arrays.asList((Object[])ReflectionUtils.invoke(list,
//                "grow",
//                new Class[]{int.class},
//                20)));
//        System.out.println(list);
//        System.out.println(ReflectionUtils.construct(B.class));

//        System.out.println(B.class.getName());
        DBCore dbCore = new DBCore();

        Book book = new Book(1, "War or Peace", "Lev");
        dbCore.insert(book);

//        dbCore.insert(new User(1, "Ivanov", "Ivan"));
//        dbCore.insert(new User(1, "Petrov", "Petr"));
    }
}