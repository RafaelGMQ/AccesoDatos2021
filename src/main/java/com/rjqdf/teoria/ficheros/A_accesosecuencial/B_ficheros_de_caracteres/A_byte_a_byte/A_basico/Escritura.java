package com.rjqdf.teoria.ficheros.A_accesosecuencial.B_ficheros_de_caracteres.A_byte_a_byte.A_basico;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Escritura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\output\\output-OutputStreamWriter.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);

            String messageToWrite = "En un lugar de la Mancha...";

            outputStreamWriter.write(messageToWrite);

            outputStreamWriter.flush();

            outputStreamWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
