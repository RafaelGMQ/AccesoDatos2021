package com.rjqdf.teoria.ficheros.A_accesosecuencial.A_ficherosdecaracteres.A_basico;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lectura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\input\\input.txt");
            FileReader fileReader = new FileReader(file);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = fileReader.read()) != -1) {

                readMessage.append((char) i);
            }

            fileReader.close();

            System.out.println(readMessage);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
