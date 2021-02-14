package com.rjqdf.teoria.A_ficheros.A_acceso_secuencial.B_ficheros_de_caracteres.B_caracter_a_caracter.A_basico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\output\\output-FileWriter.txt");
            FileWriter fileWriter = new FileWriter(file);

            String messageToWrite = "En un lugar de la Mancha...";

            fileWriter.write(messageToWrite);

            fileWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
