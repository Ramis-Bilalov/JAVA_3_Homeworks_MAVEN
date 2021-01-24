package Lesson7;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class ReflectionUtils {

    public ReflectionUtils() {}

        public static void printClassInfo(Class<?> clazz, String tag) {
            if(tag.equals("F")) {
            Field[] fields = clazz.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            System.out.println("************************************");
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField);
            }
        } else if(tag.equals("M")) {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    System.out.println(method);
                }
            }
    }

    public static void set(Object target, Object value, String fieldName) {
        try {
            Class<?> clazz = target.getClass();
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException("Field not found");
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Try set value to private field");
        }
    }

    @SneakyThrows
    public static Object invoke(Object src, String methodName, Class<?>[] classes, Object ... args) {
        Class<?> clazz = src.getClass();
        System.out.println(Arrays.toString(classes));
        Method method = clazz.getDeclaredMethod(methodName, classes);
        method.setAccessible(true);
        return method.invoke(src, args);
    }

    @SneakyThrows
    public static A construct(Class<? extends A>  clazz) {
        return A.class.getConstructor().newInstance();
    }
}
