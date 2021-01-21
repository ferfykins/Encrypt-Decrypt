package com.ferfykins.exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class TestTwo {

    public static void main(String[] args) throws IOException {


        String path = "/home/ferfykins273/Desktop/MyJavaCode/Github exercises/EncryptDecrypt/info.txt";
        String path2 = "/home/ferfykins273/Desktop/MyJavaCode/Github exercises/EncryptDecrypt/encrypt.txt";
        String path3 = "/home/ferfykins273/Desktop/MyJavaCode/Github exercises/EncryptDecrypt/decrypt.txt";
        String[] testArray = readAllLines(path);

        String[] encryptedArray = encryptArray(testArray, 5);
        String[] decryptedArray = encryptArray(encryptedArray, -5);


        writeToFile(path, decryptedArray);
        writeToFile(path2, encryptedArray);
        writeToFile(path3, decryptedArray);


    }


    /*Read an entire file, line by line, putting each line into an string array. each line being an element.
     *  Files.readAllLines();
     * ^would also work*/

    public static String[] readAllLines(String path) throws IOException {
        int totalLines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                totalLines++;
            }
        }
        String[] lines = new String[totalLines];

        try (BufferedReader nr = new BufferedReader(new FileReader(path))) {
            int i = 0;
            String line;
            while ((line = nr.readLine()) != null) {
                lines[i] = line;
                i++;
            }
        }
        return lines;
    }


    public static String[] encryptArray(String[] array, int key) {

        String[] arrayEncrypted = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            char[] line = array[i].toCharArray();
            for (int j = 0; j < line.length; j++) {
                line[j] += key;
            }

            arrayEncrypted[i] = new String(line);

        }

        return arrayEncrypted;
    }






    public static void writeToFile(String path, String[] array) throws IOException {
        Files.write(Paths.get(path), Arrays.asList(array));
    }





}
