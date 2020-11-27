package com.rjqdf.teoria.ficheros.B_accesoaleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Lectura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\input\\input.txt");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");

            randomAccessFile.seek(file.length() / 2); // Situate in the middle of the file
            String readMessage = randomAccessFile.readLine();

            randomAccessFile.close();

            System.out.println(readMessage);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
