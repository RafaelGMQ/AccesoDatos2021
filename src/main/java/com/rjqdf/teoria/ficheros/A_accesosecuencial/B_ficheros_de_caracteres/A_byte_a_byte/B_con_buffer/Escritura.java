package com.rjqdf.teoria.ficheros.A_accesosecuencial.B_ficheros_de_caracteres.A_byte_a_byte.B_con_buffer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Escritura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\output\\output-BufferedWriter.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            String messageToWrite = "En un lugar de la Mancha...";

            bufferedWriter.write(messageToWrite);

            bufferedWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
