package com.rjqdf.teoria.ficheros.A_accesosecuencial.A_ficheros_binarios.A_basico;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Lectura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\input\\input.bin");
            FileInputStream fileInputStream = new FileInputStream(file);

            int i;
            while ((i = fileInputStream.read()) != -1) {

                System.out.print(String.format("%X", i) + " ");
            }

            fileInputStream.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
