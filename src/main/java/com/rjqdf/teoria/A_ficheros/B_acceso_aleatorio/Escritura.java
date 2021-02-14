package com.rjqdf.teoria.A_ficheros.B_acceso_aleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Escritura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\output\\output-RandomAccessFile.txt");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

            String messageToWrite = "En un lugar de la Mancha...";

            randomAccessFile.writeBytes(messageToWrite);

            randomAccessFile.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
