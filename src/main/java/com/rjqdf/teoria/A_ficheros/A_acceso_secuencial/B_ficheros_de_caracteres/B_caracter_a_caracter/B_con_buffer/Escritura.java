package com.rjqdf.teoria.A_ficheros.A_acceso_secuencial.B_ficheros_de_caracteres.B_caracter_a_caracter.B_con_buffer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\output\\output-BufferedWriter.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            String messageToWrite = "En un lugar de la Mancha...";

            bufferedWriter.write(messageToWrite);

            bufferedWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
