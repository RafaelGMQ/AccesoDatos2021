package com.rjqdf.teoria.ficheros.A_acceso_secuencial.A_ficheros_binarios.B_con_buffer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Escritura {

    public static void main(String[] args) {

        try {

            File file = new File(".\\output\\output-BufferedOutputStream.bin");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));

            byte[] array = new byte[256];

            for (int i = 0; i < array.length; i++) {

                array[i] = (byte) i;
            }

            bufferedOutputStream.write(array);

            bufferedOutputStream.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
