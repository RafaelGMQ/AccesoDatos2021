package com.rjqdf.ejercicios.ejercicio3;

import java.io.File;
import java.io.IOException;

public class PropertiesTest {

    public static void main(String[] args) {

        try {

            new File("output").mkdir();

            Properties configurationFile = new Properties(".\\output\\configuration.props");

            configurationFile.setConfiguration("user", "Rafael");
            configurationFile.setConfiguration("age", "20");
            configurationFile.setConfiguration("home", "C:\\users\\Rafael\\");

            System.out.println(configurationFile.getConfiguration("user"));
            configurationFile.deleteConfiguration("user");
            System.out.println(configurationFile.getConfiguration("user"));
//            configurationFile.deleteFile();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
