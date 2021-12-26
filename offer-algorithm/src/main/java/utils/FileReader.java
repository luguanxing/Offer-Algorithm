package utils;

import java.io.*;

public class FileReader {

    public static String readLine(String path) {
        try {
            BufferedReader in = new BufferedReader(new java.io.FileReader(path));
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        String line = readLine("/Users/luguanxing/1");
        System.out.println(line);
    }

}
