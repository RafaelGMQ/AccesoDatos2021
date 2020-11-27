package com.rjqdf.teoria.ficheros.A_acceso_secuencial.B_ficheros_de_caracteres.A_byte_a_byte.B_con_buffer;

import java.io.BufferedReader;
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
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = bufferedReader.read()) != -1) {

                readMessage.append((char) i);
            }

            bufferedReader.close();

            System.out.println(readMessage);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
