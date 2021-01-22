package com.rjqdf.ejercicios.ej3;

import java.io.IOException;

public class BufferedReaderTest {

    public static void main(String[] args) {

        try {

            BufferedReader bufferedReader = new BufferedReader(".\\input\\quijote.txt");

            String readMessage;
            int i = 0;
            while ((readMessage = bufferedReader.readLine()) != null){

                System.out.println(++i + ". " + readMessage);
            }

            System.out.println(bufferedReader.readLine());

            bufferedReader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
