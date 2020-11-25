package com.rjqdf.ejercicios;

import org.apache.commons.text.WordUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        apartado1();
//        apartado2();
//        apartado3();
//        apartado4();
//        apartado5();
//        apartado5Scanner();
//        apartado6();
//        apartado7();
//        apartado8();
//        apartado9();
    }

    public static void apartado1() {

        final int SAMPLE_SPACE = 10;

        // TEST WITH FILEREADER

        long[] timeWithFileReaderArray = new long[SAMPLE_SPACE];
        long timeWithFileReader = 0;
        for (int i = 0; i < timeWithFileReaderArray.length; i++) {

            timeWithFileReaderArray[i] = readWithFileReader();
            timeWithFileReader += timeWithFileReaderArray[i];
        }
        timeWithFileReader /= SAMPLE_SPACE;


        // TEST WITH BUFFEREDREADER

        long[] timeWithBufferedReaderArray = new long[SAMPLE_SPACE];
        long timeWithBufferedReader = 0;
        for (int i = 0; i < timeWithBufferedReaderArray.length; i++) {

            timeWithBufferedReaderArray[i] = readWithBufferedReader();
            timeWithBufferedReader += timeWithBufferedReaderArray[i];
        }
        timeWithBufferedReader /= SAMPLE_SPACE;


        // TEST WITH FILEREADER ONLY ONE HD ACCESS

        long[] timeWithFileReaderOnlyOneHDAccessArray = new long[SAMPLE_SPACE];
        long timeWithFileReaderOnlyOneHDAccess = 0;
        for (int i = 0; i < timeWithFileReaderOnlyOneHDAccessArray.length; i++) {

            timeWithFileReaderOnlyOneHDAccessArray[i] = readWithFileReaderOnlyOneHDAccess();
            timeWithFileReaderOnlyOneHDAccess += timeWithFileReaderOnlyOneHDAccessArray[i];
        }
        timeWithFileReaderOnlyOneHDAccess /= SAMPLE_SPACE;


        // PRINT RESULTS

        System.out.println("\n");
        System.out.println("FileReader - read()");
        for (int i = 0; i < SAMPLE_SPACE; i++) {

            System.out.println("Ejecución " + (i+1) + ": " + String.format("%,d", timeWithFileReaderArray[i]) + " nanosegundos");
        }
        System.out.println("TIEMPO MEDIO: " + String.format("%,d", timeWithFileReader) + " nanosegundos\n");

        System.out.println("BufferedReader - readLine()");
        for (int i = 0; i < SAMPLE_SPACE; i++) {

            System.out.println("Ejecución " + (i+1) + ": " + String.format("%,d", timeWithBufferedReaderArray[i]) + " nanosegundos");
        }
        System.out.println("TIEMPO MEDIO: " + String.format("%,d", timeWithBufferedReader) + " nanosegundos\n");

        System.out.println("FileReader - read(char[] buffer)");
        for (int i = 0; i < SAMPLE_SPACE; i++) {

            System.out.println("Ejecución " + (i+1) + ": " + String.format("%,d", timeWithFileReaderOnlyOneHDAccessArray[i]) + " nanosegundos");
        }
        System.out.println("TIEMPO MEDIO: " + String.format("%,d", timeWithFileReaderOnlyOneHDAccess) + " nanosegundos\n");


        System.out.println("FileReader tarda unas " + ((double) timeWithFileReader / timeWithBufferedReader) + " veces más que BufferedReader");
    }

    public static long readWithBufferedReader() {

        long startTime = System.nanoTime();

        try {

            File file = new File(".\\input\\quijote.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String message;

            while ((message = bufferedReader.readLine()) != null){
                System.out.println(message);
            }

            bufferedReader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        long stopTime = System.nanoTime();

        return (stopTime - startTime);
    }

    public static long readWithFileReader() {

        long startTime = System.nanoTime();

        try {

            File file = new File(".\\input\\quijote.txt");
            FileReader fileReader = new FileReader(file);

            int i;
            while ((i = fileReader.read()) != -1) {

                System.out.print((char) i);
            }

            fileReader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        long stopTime = System.nanoTime();

        return (stopTime - startTime);
    }

    public static long readWithFileReaderOnlyOneHDAccess() {

        long startTime = System.nanoTime();

        try {

            File file = new File(".\\input\\quijote.txt");
            FileReader fileReader = new FileReader(file);

            char[] buffer = new char[1_040_581];
            fileReader.read(buffer);
            System.out.println(new String(buffer));

            fileReader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        long stopTime = System.nanoTime();

        return (stopTime - startTime);
    }

    public static void apartado2() {

        try {

            File file = new File(".\\input\\quijote.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String message;
            int numberOfCharacters = 0;
            int sizeInBytes = 0;

            while ((message = bufferedReader.readLine()) != null){

                // Each line has 2 extra characters (Carriage Return and Line Feed)
                numberOfCharacters += (message.length() + 2);

                byte[] utf8Bytes = message.getBytes(StandardCharsets.UTF_8);
                sizeInBytes += (utf8Bytes.length + 2);
            }

            // The last line does not have 2 extra characters since this one does not have a new line after
            numberOfCharacters -= 2;
            sizeInBytes -= 2;

            bufferedReader.close();

            System.out.println("El número de caracteres es: " + numberOfCharacters);
            System.out.println("El tamaño en bytes de todos los caracteres es: " + sizeInBytes);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado3() {

        try {

            File file = new File(".\\input\\quijote.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String message;
            int numberOfNonAsciiCharacters = 0;
            int numberOfAsciiCharacters = 0;
            int tilde = 0;
            int nTilde = 0;
            int diaeresis = 0;
            int openQuestion = 0;
            int openExclamation = 0;
            int hyphen = 0; // guión
            int leftPointingDoubleAngleQuotationMark = 0;
            int rightPointingDoubleAngleQuotationMark = 0;
            int openApostrophe = 0;
            int closeApostrophe = 0;
            int openQuotationMark = 0;
            int closeQuotationMark = 0;
            int anotherTilde = 0;

            while ((message = bufferedReader.readLine()) != null){

                for (int i = 0; i < message.length(); i++) {

                    char currentChar = message.charAt(i);

                    if ( currentChar >= 128 ){

                        numberOfNonAsciiCharacters++;

                        if ( currentChar == 769 ) {

                            tilde++;

                        } else if ( currentChar ==  771 ) {

                            nTilde++;

                        } else if ( currentChar ==  776 ) {

                            diaeresis++;

                        } else if ( currentChar ==  191 ) {

                            openQuestion++;

                        } else if ( currentChar ==  161 ) {

                            openExclamation++;

                        } else if ( currentChar ==  8211 ) {

                            hyphen++;

                        } else if ( currentChar ==  171 ) {

                            leftPointingDoubleAngleQuotationMark++;

                        } else if ( currentChar ==  187 ) {

                            rightPointingDoubleAngleQuotationMark++;

                        } else if ( currentChar ==  8216 ) {

                            openApostrophe++;

                        } else if ( currentChar ==  8217 ) {

                            closeApostrophe++;

                        } else if ( currentChar ==  8220 ) {

                            openQuotationMark++;

                        } else if ( currentChar ==  8221 ) {

                            closeQuotationMark++;

                        } else if ( currentChar ==  768 ) {

                            anotherTilde++;
                            System.out.println(message);

                        } else {

                            System.out.print(currentChar + " ");
                        }

                    } else {

                        numberOfAsciiCharacters++;
                    }
                }

                // Each line has 2 extra characters (Carriage Return and Line Feed)
                numberOfAsciiCharacters += 2;
            }

            // The last line does not have 2 extra characters since this one does not have a new line after
            numberOfAsciiCharacters -= 2;

            bufferedReader.close();

            System.out.println();
            System.out.println("El número de caracteres que pertenecen a la tabla ASCII es: " + numberOfAsciiCharacters);
            System.out.println("El número de caracteres que NO pertenecen a la tabla ASCII es: " + numberOfNonAsciiCharacters);
            System.out.println("\tCarácter tilde = " + tilde);
            System.out.println("\tCarácter tilde de la ñ = " + nTilde);
            System.out.println("\tCarácter diéresis = " + diaeresis);
            System.out.println("\tCarácter ¿ = " + openQuestion);
            System.out.println("\tCarácter ¡ = " + openExclamation);
            System.out.println("\tCarácter – = " + hyphen);
            System.out.println("\tCarácter « = " + leftPointingDoubleAngleQuotationMark);
            System.out.println("\tCarácter » = " + rightPointingDoubleAngleQuotationMark);
            System.out.println("\tCarácter ‘ = " + openApostrophe);
            System.out.println("\tCarácter ’ = " + closeApostrophe);
            System.out.println("\tCarácter “ = " + openQuotationMark);
            System.out.println("\tCarácter ” = " + closeQuotationMark);
            System.out.println("\tCarácter ̀  = " + anotherTilde);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado4() {

        try {

            File file = new File(".\\input\\quijote.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String message;
            int numberOfUppercaseLetters = 0;

            while ((message = bufferedReader.readLine()) != null){

                for (int i = 0; i < message.length(); i++) {

                    char currentChar = message.charAt(i);

                    if (currentChar >= 65 && currentChar <= 90) {

                        numberOfUppercaseLetters++;
                    }
                }
            }

            bufferedReader.close();

            System.out.println("El fichero adjunto contiene " + numberOfUppercaseLetters + " caracteres en mayúscula");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado5() {

        try {

            File file = new File(".\\input\\quijote.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String message;
            int numberOfWords = 0;

            while ((message = bufferedReader.readLine()) != null){

                String[] words = message.split(" ");
                numberOfWords += words.length;
            }

            bufferedReader.close();

            System.out.println("El fichero adjunto contiene " + numberOfWords + " palabras");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado5Scanner() {

        File file = new File(".\\input\\quijote.txt");

        try {

            Scanner scanner = new Scanner(new FileInputStream(file));

            int numberOfWords = 0;
            while (scanner.hasNext()) {

                scanner.next();
                numberOfWords++;
            }

            System.out.println("El fichero adjunto contiene " + numberOfWords + " palabras");

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }

    public static void apartado6() {

        System.out.println("TIEMPO REALIZANDO UNA SOLA ESCRITURA:");

        long timeWithBufferedWriter = oneWriteWithBufferedWriter();
        long timeWithFileWriter = oneWriteWithFileWriter();

        System.out.println("Tiempo usando buffer: " + timeWithBufferedWriter + " nanosegundos");
        System.out.println("Tiempo sin usar buffer: " + timeWithFileWriter + " nanosegundos");
        System.out.println("BufferedWriter tarda unas " + ((double) timeWithBufferedWriter / timeWithFileWriter) + " veces más que FileWriter");

        System.out.println("\n\nTIEMPO REALIZANDO MUCHAS ESCRITURAS PEQUEÑAS:");
        timeWithBufferedWriter = severalWritesWithBufferedWriter();
        timeWithFileWriter = severalWritesWithFileWriter();
        System.out.println("Tiempo usando buffer: " + timeWithBufferedWriter + " nanosegundos");
        System.out.println("Tiempo sin usar buffer: " + timeWithFileWriter + " nanosegundos");
        System.out.println("FileWriter tarda unas " + ((double) timeWithFileWriter / timeWithBufferedWriter) + " veces más que BufferedWriter");
    }

    public static long oneWriteWithBufferedWriter() {

        long startTime = 0;
        long stopTime = 0;

        try {

            File inputFile = new File(".\\input\\quijote.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

            String readMessage;
            StringBuilder fileContent = new StringBuilder();

            while ((readMessage = bufferedReader.readLine()) != null){
                fileContent.append(readMessage).append("\r\n");
            }

            bufferedReader.close();

            startTime = System.nanoTime();

            File outputFile = new File(".\\output\\salida-quijote.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
            bufferedWriter.write(fileContent.toString());
            bufferedWriter.close();

            stopTime = System.nanoTime();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return (stopTime - startTime);
    }

    public static long oneWriteWithFileWriter() {

        long startTime = 0;
        long stopTime = 0;

        try {

            File inputFile = new File(".\\input\\quijote.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

            String readMessage;
            StringBuilder fileContent = new StringBuilder();

            while ((readMessage = bufferedReader.readLine()) != null){
                fileContent.append(readMessage).append("\r\n");
            }

            bufferedReader.close();

            startTime = System.nanoTime();

            File outputFile = new File(".\\output\\salida-quijote.txt");
            FileWriter fileWriter = new FileWriter(outputFile);
            fileWriter.write(fileContent.toString());
            fileWriter.close();

            stopTime = System.nanoTime();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return (stopTime - startTime);
    }

    public static long severalWritesWithBufferedWriter() {

        long startTime = 0;
        long stopTime = 0;

        try {

            File inputFile = new File(".\\input\\quijote.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

            String readMessage;
            List<String> fileContent = new ArrayList<>();

            // Put fileContent in a List including only 5 characters in each position
            while ((readMessage = bufferedReader.readLine()) != null){

                StringBuilder readMessageFragment = new StringBuilder();

                for (int i = 0; i < readMessage.length(); i++) {

                    readMessageFragment.append(readMessage.charAt(i));

                    if ( i % 5 == 0 ) {

                        fileContent.add(readMessageFragment.toString());
                        readMessageFragment = new StringBuilder();
                    }
                }

                fileContent.add(readMessageFragment.toString() + "\r\n");
            }

            bufferedReader.close();

            startTime = System.nanoTime();

            File outputFile = new File(".\\output\\salida-quijote.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

            for (String messageToWrite : fileContent) {

                bufferedWriter.write(messageToWrite);
            }

            bufferedWriter.close();

            stopTime = System.nanoTime();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return (stopTime - startTime);
    }

    public static long severalWritesWithFileWriter() {

        long startTime = 0;
        long stopTime = 0;

        try {

            File inputFile = new File(".\\input\\quijote.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

            String readMessage;
            List<String> fileContent = new ArrayList<>();

            // Put fileContent in a List including only 5 characters in each position
            while ((readMessage = bufferedReader.readLine()) != null){

                StringBuilder readMessageFragment = new StringBuilder();

                for (int i = 0; i < readMessage.length(); i++) {

                    readMessageFragment.append(readMessage.charAt(i));

                    if ( i % 5 == 0 ) {

                        fileContent.add(readMessageFragment.toString());
                        readMessageFragment = new StringBuilder();
                    }
                }

                fileContent.add(readMessageFragment.toString() + "\r\n");
            }

            bufferedReader.close();

            startTime = System.nanoTime();

            File outputFile = new File(".\\output\\salida-quijote.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            for (String messageToWrite : fileContent) {

                fileWriter.write(messageToWrite);
            }

            fileWriter.close();

            stopTime = System.nanoTime();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return (stopTime - startTime);
    }

    public static void apartado7() {

        try {

            File inputFile = new File(".\\input\\quijote.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

            String readMessage;
            StringBuilder fileContent = new StringBuilder();

            while ((readMessage = bufferedReader.readLine()) != null){
                /*
                 * The end of line has to be only \n because otherwise, \r\n will be reversed and the output file will
                 * have two new lines for each end of line.
                 */
                fileContent.append(readMessage).append("\n");
            }

            bufferedReader.close();

            File outputFile = new File(".\\output\\salidaInvertida-quijote.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
            bufferedWriter.write(fileContent.reverse().toString());
            bufferedWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado8() {

        try {

            File inputFile = new File(".\\input\\quijote.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

            String readMessage;
            StringBuilder fileContent = new StringBuilder();

            while ((readMessage = bufferedReader.readLine()) != null){

                char[] readMessageCharacters = readMessage.toCharArray();
                for (int i = 0; i < readMessageCharacters.length; i++) {

                    if (readMessageCharacters[i] == 'o') {

                        if (i != (readMessageCharacters.length - 1) && readMessageCharacters[i+1] == 769) { // 769 = tilde char

                            readMessageCharacters[i] = 'O';
                        }
                    }
                }

                fileContent.append(String.valueOf(readMessageCharacters)).append("\r\n");
            }

            bufferedReader.close();

            File outputFile = new File(".\\output\\salidaLetraSustituida-quijote.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
            bufferedWriter.write(fileContent.toString());
            bufferedWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado9() {

        try {

            File inputFile = new File(".\\input\\quijote.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

            String readMessage;
            StringBuilder fileContent = new StringBuilder();

            while ((readMessage = bufferedReader.readLine()) != null){

                fileContent.append(readMessage).append("\r\n");
            }

            bufferedReader.close();

            File outputFile = new File(".\\output\\salidaMayusculas-quijote.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
            bufferedWriter.write(WordUtils.capitalize(fileContent.toString()));
            bufferedWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}