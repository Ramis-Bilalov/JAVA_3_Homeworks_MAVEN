package Lesson3.classwork;

import java.io.*;

public class Tests {
    public static void main(String[] args) throws IOException {
        InputStream stream = Tests.class.getResourceAsStream("data.txt");
        OutputStream os = new FileOutputStream("data.txt", true);
        IoUtils.writeString(os,"Hello World");
        IoUtils.copyBuffered("history.txt", "historyto.txt");
    }
}
