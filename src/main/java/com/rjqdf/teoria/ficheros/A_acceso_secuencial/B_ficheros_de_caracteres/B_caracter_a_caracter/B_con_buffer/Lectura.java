package com.rjqdf.teoria.ficheros.A_acceso_secuencial.B_ficheros_de_caracteres.B_caracter_a_caracter.B_con_buffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lectura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\input\\input.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String readMessage = bufferedReader.readLine();

            bufferedReader.close();

            System.out.println(readMessage);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
