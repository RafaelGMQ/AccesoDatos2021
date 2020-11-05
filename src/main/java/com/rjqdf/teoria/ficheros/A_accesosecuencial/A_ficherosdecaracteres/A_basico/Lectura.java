package com.rjqdf.teoria.ficheros.A_accesosecuencial.A_ficherosdecaracteres.A_basico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lectura {

    public static void main(String[] args) {

        try {

            File file = new File("input.txt");
            FileReader fileReader = new FileReader(file);

            int i;
            String message = "";
            while ((i = fileReader.read()) != -1) {

                message += (char) i;

            }

            fileReader.close();

            System.out.println(message);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
