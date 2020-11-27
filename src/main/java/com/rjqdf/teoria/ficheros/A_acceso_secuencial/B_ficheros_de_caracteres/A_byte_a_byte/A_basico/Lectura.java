package com.rjqdf.teoria.ficheros.A_acceso_secuencial.B_ficheros_de_caracteres.A_byte_a_byte.A_basico;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Lectura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\input\\input.bin");
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = inputStreamReader.read()) != -1) {

                readMessage.append((char) i);
            }

            inputStreamReader.close();

            System.out.println(readMessage);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
