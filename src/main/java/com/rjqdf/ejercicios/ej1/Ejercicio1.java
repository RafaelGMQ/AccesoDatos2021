package com.rjqdf.ejercicios.ej1;

import org.apache.commons.text.WordUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Ejercicio1 {

    public static void main(String[] args) {

        new File("output").mkdir();

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
//        apartado12Library();
//        apartado13();
        apartado14();
    }

    public static void apartado3() {

        try {

            File file = new File(".\\input\\entrada.txt");
            FileReader fileReader = new FileReader(file);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = fileReader.read()) != -1) {

                readMessage.append((char) i);
            }

            fileReader.close();

            System.out.println(readMessage);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado4() {

        try {

            File file = new File(".\\input\\entrada.txt");
            FileReader fileReader = new FileReader(file);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = fileReader.read()) != -1) {

                readMessage.append((char) i);
            }

            fileReader.close();

            System.out.println("El fichero adjunto contiene " + readMessage.length() + " caracteres");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado5() {

        char aTilde = '\u00E1'; // UTF-8: á = U+00E1
        char eTilde = '\u00E9'; // UTF-8: é = U+00E9
        char iTilde = '\u00ED'; // UTF-8: í = U+00ED
        char oTilde = '\u00F3'; // UTF-8: ó = U+00F3
        char uTilde = '\u00FA'; // UTF-8: ú = U+00FA

        try {

            File file = new File(".\\input\\entrada.txt");
            FileReader fileReader = new FileReader(file);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = fileReader.read()) != -1) {

                char readChar = (char) i;

                if (readChar == aTilde || readChar == eTilde || readChar == iTilde || readChar == oTilde || readChar == uTilde) {

                    readMessage.append(readChar);
                }
            }

            fileReader.close();

            System.out.println("El fichero adjunto contiene " + readMessage.length() + " caracteres con tilde");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado6() {

        try {

            File file = new File(".\\input\\entrada.txt");
            FileReader fileReader = new FileReader(file);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = fileReader.read()) != -1) {

                if (i >= 65 && i <= 90) {

                    readMessage.append((char) i);
                }
            }

            fileReader.close();

            System.out.println("El fichero adjunto contiene " + readMessage.length() + " caracteres en mayúscula");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado7() {

        try {

            File file = new File(".\\input\\entrada.txt");
            FileReader fileReader = new FileReader(file);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = fileReader.read()) != -1) {

                readMessage.append((char) i);
            }

            fileReader.close();

            String[] words = readMessage.toString().split(" ");
            int numberOfWords = 0;
            for (String word : words) {

//                System.out.println(words[j]);

                if (word.length() > 0) {

                    numberOfWords++;
                }
            }

            System.out.println("El fichero adjunto contiene " + numberOfWords + " palabras");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado8() {

        try {

            File file = new File(".\\output\\fibonacci.txt");
            FileWriter fileWriter = new FileWriter(file);

            BigInteger numberA = new BigInteger("0");
            BigInteger numberB = new BigInteger("1");
            BigInteger addition = new BigInteger("1");

            for (int i = 1; i <= 1000; i++) {

                fileWriter.write(addition.toString());
                fileWriter.write("\r\n");

                // Update values
                addition = numberA.add(numberB);
                numberA = numberB;
                numberB = addition;
            }

            fileWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado9() {

        try {

            File inputFile = new File(".\\input\\entrada.txt");
            FileReader fileReader = new FileReader(inputFile);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = fileReader.read()) != -1) {

                readMessage.append((char) i);
            }

            fileReader.close();

            File outputFile = new File(".\\output\\salida.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            fileWriter.write(readMessage.toString());

            fileWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado10() {

        try {

            File inputFile = new File(".\\input\\entrada.txt");
            FileReader fileReader = new FileReader(inputFile);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = fileReader.read()) != -1) {

                readMessage.append((char) i);
            }

            fileReader.close();

            File outputFile = new File(".\\output\\salidaInvertida.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            StringBuilder reverseMessage = new StringBuilder(readMessage).reverse();

            fileWriter.write(reverseMessage.toString());

            fileWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado11() {

        try {

            File inputFile = new File(".\\input\\entrada.txt");
            FileReader fileReader = new FileReader(inputFile);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = fileReader.read()) != -1) {

                char readChar = (char) i;

                if (readChar == 'e') {

                    readMessage.append('E');

                } else {

                    readMessage.append(readChar);
                }
            }

            fileReader.close();

            File outputFile = new File(".\\output\\salidaLetraSustituida.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            fileWriter.write(readMessage.toString());

            fileWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado12() {

        try {

            File inputFile = new File(".\\input\\entrada.txt");
            FileReader fileReader = new FileReader(inputFile);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = fileReader.read()) != -1) {

                readMessage.append((char) i);
            }

            fileReader.close();

            String[] words = readMessage.toString().split(" ");

            StringBuilder readMessageUppercase = new StringBuilder();
            for (String word : words) {

                if (word.length() > 0) {

                    // Uppercase first letter of each word
                    readMessageUppercase.append(word.substring(0, 1).toUpperCase());
                    readMessageUppercase.append(word.substring(1));
                }
                readMessageUppercase.append(" ");
            }

            File outputFile = new File(".\\output\\salidaMayusculas.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            fileWriter.write(readMessageUppercase.toString());

            fileWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado12Library() {

        try {

            File inputFile = new File(".\\input\\entrada.txt");
            FileReader fileReader = new FileReader(inputFile);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = fileReader.read()) != -1) {

                readMessage.append((char) i);
            }

            fileReader.close();

            File outputFile = new File(".\\output\\salidaMayusculas.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            fileWriter.write(WordUtils.capitalize(readMessage.toString()));

            fileWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado13() {

        try {

            File inputFile = new File(".\\input\\entrada.txt");
            FileReader fileReader = new FileReader(inputFile);

            int i;
            StringBuilder readMessage = new StringBuilder();
            while ((i = fileReader.read()) != -1) {

                char readChar = (char) i;

                if (readChar != 'a' && readChar != 'e' && readChar != 'i' && readChar != 'o' && readChar != 'u'
                        && readChar != 'A' && readChar != 'E' && readChar != 'I' && readChar != 'O' && readChar != 'U'
                        && readChar != 'á' && readChar != 'é' && readChar != 'í' && readChar != 'ó' && readChar != 'ú'
                        && readChar != 'Á' && readChar != 'É' && readChar != 'Í' && readChar != 'Ó' && readChar != 'Ú') {

                    readMessage.append(readChar);
                }
            }

            fileReader.close();

            File outputFile = new File(".\\output\\salidaSinVocales.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            fileWriter.write(readMessage.toString());

            fileWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado14() {

        try {

            File inputFile = new File(".\\input\\entrada.txt");
            FileReader fileReader = new FileReader(inputFile);

            String message;
            while ((message = readParagraph(fileReader)) != null){
                System.out.println(message);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String readParagraph(FileReader fileReader) throws IOException {

        boolean iterate = true;
        boolean exit = false;
        StringBuilder readMessage = new StringBuilder();

        do {

            int readInt = fileReader.read();

            if ( readInt == (int) '\r' ) {

                // Do nothing because new-line-characters has not to be added.
                // In addition, if a '\r' character is found, the loop has to continue
                // iterating because next character has to be '\n'.

            } else if ( readInt == (int) '\n' || readInt == -1 ) {

                iterate = false;

                if (readInt == -1) {

                    exit = true;
                }

            } else {

                readMessage.append((char) readInt);
            }

        } while (iterate);

        if (exit && readMessage.length() == 0) {

            return null;
        }

        return readMessage.toString();
    }
}
