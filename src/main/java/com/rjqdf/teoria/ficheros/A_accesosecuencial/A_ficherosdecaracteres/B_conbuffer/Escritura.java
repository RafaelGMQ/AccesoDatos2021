package com.rjqdf.teoria.ficheros.A_accesosecuencial.A_ficherosdecaracteres.B_conbuffer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura {

    public static void main(String[] args) {

        try {

            File file = new File("output.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            String messageToWrite = "En un lugar de la Mancha...";

            bufferedWriter.write(messageToWrite);

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}

