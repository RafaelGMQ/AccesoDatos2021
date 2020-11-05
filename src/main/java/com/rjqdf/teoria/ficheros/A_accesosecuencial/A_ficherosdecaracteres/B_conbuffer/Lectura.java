package com.rjqdf.teoria.ficheros.A_accesosecuencial.A_ficherosdecaracteres.B_conbuffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
            fileReader.close();

            System.out.println(readMessage);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}

