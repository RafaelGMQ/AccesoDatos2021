package com.rjqdf.teoria.ficheros.A_accesosecuencial.A_ficherosdecaracteres.A_basico;

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
