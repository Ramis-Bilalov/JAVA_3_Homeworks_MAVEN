package Lesson3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

public final class IoUtils {

    private IoUtils() {}

    public static void copy(String src, String dst) throws IOException {
        long start = Instant.now().toEpochMilli();
        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dst);
        int cur = 0;
        while((cur = is.read()) != -1) {
            os.write(cur);
        }
        os.flush();
        long end = Instant.now().toEpochMilli();
        System.out.println("time: " + (end - start));
    }

    public static void copyBuffered(String src, String dst) throws IOException {
        long start = Instant.now().toEpochMilli();
        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dst);
        byte[] buffer = new byte[1024];
        int read = 0;
        while((read = is.read(buffer)) != -1) {
            os.write(buffer, 0, read);
        }
        os.flush();
        long end = Instant.now().toEpochMilli();
        System.out.println("time: " + (end - start));
    }

    public static void writeString(OutputStream os, String data) throws IOException {
        os.write(data.getBytes(StandardCharsets.UTF_8));
        os.flush();
    }

    public static String readWord(InputStream is) throws IOException {
        int cur;
        StringBuilder s = new StringBuilder();
        while((cur = is.read()) != -1) {
            if(cur == ' ' || cur == '\n' || cur == '\r') {
                if(s.length() > 0) {
                    return s.toString();
                }
            } else {
                s.append((char)cur);
            }
        }
        return s.length() > 0 ? s.toString() : null;
    }
}
