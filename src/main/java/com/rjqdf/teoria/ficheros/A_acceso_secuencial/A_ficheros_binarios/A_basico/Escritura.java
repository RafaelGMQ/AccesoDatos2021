package com.rjqdf.teoria.ficheros.A_acceso_secuencial.A_ficheros_binarios.A_basico;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Escritura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\output\\output-FileOutputStream.bin");
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            byte[] array = new byte[256];

            for (int i = 0; i < array.length; i++) {

                array[i] = (byte) i;
            }

            fileOutputStream.write(array);

            fileOutputStream.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
