package Lesson1.classwork;

public class MyArray {
    private Object[] data;
    private int size, capacity;

    public MyArray() {
        size = 0;
        capacity = 128;
        data = new Object[capacity];
    }

    public Object get(int index) {
        return data[index];
    }

    public void set(int index, Object o) {
        data[index] = o;
    }

    public void add(Object o) {
        validateCapacity();
        data[size] = o;
        size++;
    }

    public void remove() {
        size--;
    }

    private void validateCapacity() {
        if(size == capacity - 1) {
            capacity *= 2;
            Object[] tmp = new Object[capacity];
            if (size >= 0) {
                System.arraycopy(data, 0, tmp, 0, size);
            }
            data = tmp;
        }
    }
}
