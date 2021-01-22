package com.rjqdf.ejercicios.ej3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Properties {

    private File file;

    public Properties(String path) throws IOException {

        file = new File(path);
        file.createNewFile();
    }

    public String getConfiguration(String key) throws IOException {

        return this.getConfiguration(key, null);
    }

    public String getConfiguration(String key, String defaultValue) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = bufferedReader.readLine()) != null){

            String[] pairKeyValue = line.split("=");

            if (pairKeyValue[0].trim().equals(key)) {

                bufferedReader.close();
                return pairKeyValue[1];
            }
        }

        bufferedReader.close();

        return defaultValue;
    }

    public void setConfiguration(String key, String value) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        boolean updated = false;
        StringBuilder fileContent = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null){

            String[] pairKeyValue = line.split("=");

            if (pairKeyValue[0].trim().equals(key)) {

                fileContent.append(pairKeyValue[0]).append('=').append(value).append('\n');
                updated = true;

            } else {

                fileContent.append(line).append('\n');
            }
        }

        bufferedReader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        if (!updated) {

            fileContent.append(key).append('=').append(value).append('\n');
        }

        bufferedWriter.write(fileContent.toString());
        bufferedWriter.close();
    }

    public void deleteConfiguration(String key) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        StringBuilder fileContent = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null){

            String[] pairKeyValue = line.split("=");

            if (!pairKeyValue[0].trim().equals(key)) {

                fileContent.append(line).append('\n');
            }
        }

        bufferedReader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(fileContent.toString());
        bufferedWriter.close();
    }

    public boolean deleteFile() {

        return file.delete();
    }
}
