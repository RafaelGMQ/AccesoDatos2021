package com.rjqdf.ejercicios;

import org.apache.commons.text.WordUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {

    public static void main(String[] args) {

//        apartado3();
//        apartado4();
//        apartado5();
//        apartado6();
//        apartado7();
//        apartado8();
//        apartado9();
//        apartado10();
//        apartado11();
//        apartado12();
        apartado13();
    }

    public static void apartado3() {

        try {

            File file = new File("entrada.txt");
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

    public static void apartado4() {

        try {

            File file = new File("entrada.txt");
            FileReader fileReader = new FileReader(file);

            int i;
            String message = "";
            while ((i = fileReader.read()) != -1) {

                message += (char) i;

            }

            fileReader.close();

            System.out.println(message.length());

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado5() {

        char aTilde = 'á';
        char eTilde = 'é';
        char iTilde = 'í';
        char oTilde = 'ó';
        char uTilde = 'ú';

        try {

            File file = new File("entrada.txt");
            FileReader fileReader = new FileReader(file);

            int i;
            String message = "";
            while ((i = fileReader.read()) != -1) {

                char readChar = (char) i;

                if (readChar == aTilde || readChar == eTilde || readChar == iTilde || readChar == oTilde || readChar == uTilde) {

                    message += readChar;
                }

            }

            fileReader.close();

            System.out.println(message.length());

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado6() {

        try {

            File file = new File("entrada.txt");
            FileReader fileReader = new FileReader(file);

            int i;
            String message = "";
            while ((i = fileReader.read()) != -1) {

                if (i >= 65 && i <= 90) {

                    message += (char) i;
                }

            }

            fileReader.close();

            System.out.println(message.length());

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado7() {

        try {

            File file = new File("entrada.txt");
            FileReader fileReader = new FileReader(file);

            int i;
            String message = "";
            while ((i = fileReader.read()) != -1) {

                message += (char) i;
            }

            fileReader.close();

            String[] words = message.split(" ");
            int numberOfWords = 0;
            for (int j = 0; j < words.length; j++) {

//                System.out.println(words[j]);

                if (words[j].length() > 0) {

                    numberOfWords++;
                }
            }

            System.out.println(numberOfWords);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado8() {

        try {

            File file = new File("fibonacci.txt");
            FileWriter fileWriter = new FileWriter(file);




            double[] arrayFibonacci = new double[1000];

            double numeroA = 1;
            double numeroB = 1;

            arrayFibonacci[0] = numeroA;
            arrayFibonacci[1] = numeroB;


            for (int i = 2; i < arrayFibonacci.length; i++) {

                arrayFibonacci[i] = numeroA + numeroB;

                numeroA = numeroB;

                numeroB = arrayFibonacci[i];
            }

            System.out.print('[');

            for(int i = 0; i < arrayFibonacci.length; i++) {

                fileWriter.write(arrayFibonacci[i] + "\r\n");

//                if( i != (arrayFibonacci.length - 1)) {
//                    System.out.print(i + ": " + arrayFibonacci[i] + ", ");
//                } else {
//                    System.out.print(i + ": " + arrayFibonacci[i] + ']');
//                }
            }

            fileWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado9() {

        try {

            File inputFile = new File("entrada.txt");
            FileReader fileReader = new FileReader(inputFile);

            int i;
            String message = "";
            while ((i = fileReader.read()) != -1) {

                message += (char) i;

            }

            fileReader.close();

            File outputFile = new File("salida.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            fileWriter.write(message);

            fileWriter.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado10() {

        try {

            File inputFile = new File("entrada.txt");
            FileReader fileReader = new FileReader(inputFile);

            int i;
            String message = "";
            while ((i = fileReader.read()) != -1) {

                message += (char) i;

            }

            fileReader.close();

            String invertedMessage = "";
            for (int j = message.length()-1; j >= 0; j--){

                invertedMessage += message.charAt(j);
            }

            File outputFile = new File("salidaInvertida.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            fileWriter.write(invertedMessage);

            fileWriter.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado11() {

        try {

            File inputFile = new File("entrada.txt");
            FileReader fileReader = new FileReader(inputFile);

            int i;
            String message = "";
            while ((i = fileReader.read()) != -1) {

                char readChar = (char) i;

                if (readChar == 'e') {

                    message += Character.toUpperCase(readChar);

                } else {

                    message += (char) i;
                }
            }

            fileReader.close();

            File outputFile = new File("salidaLetraSustituida.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            fileWriter.write(message);

            fileWriter.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado12() {

        try {

            File inputFile = new File("entrada.txt");
            FileReader fileReader = new FileReader(inputFile);

            int i;
            String message = "";
            while ((i = fileReader.read()) != -1) {

                message += (char) i;

            }

            fileReader.close();

            File outputFile = new File("salidaMayusculas.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            fileWriter.write(WordUtils.capitalize(message));

            fileWriter.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado13() {

        try {

            File inputFile = new File("entrada.txt");
            FileReader fileReader = new FileReader(inputFile);

            int i;
            String message = "";
            while ((i = fileReader.read()) != -1) {

                char readChar = (char) i;

                if (readChar != 'a' && readChar != 'e' && readChar != 'i' && readChar != 'o' && readChar != 'u'
                        && readChar != 'A' && readChar != 'E' && readChar != 'I' && readChar != 'O' && readChar != 'U'
                        && readChar != 'á' && readChar != 'é' && readChar != 'í' && readChar != 'ó' && readChar != 'ú'
                        && readChar != 'Á' && readChar != 'É' && readChar != 'Í' && readChar != 'Ó' && readChar != 'Ú') {

                    message += (char) i;
                }
            }

            fileReader.close();

            File outputFile = new File("salidaSinVocales.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            fileWriter.write(message);

            fileWriter.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
