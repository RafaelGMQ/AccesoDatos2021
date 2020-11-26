package com.rjqdf.teoria.ficheros.A_accesosecuencial.A_ficheros_binarios.B_con_buffer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Lectura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\input\\input.bin");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));

            int i;
            while ((i = bufferedInputStream.read()) != -1) {

                System.out.print(String.format("%X", i) + " ");
            }

            bufferedInputStream.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
