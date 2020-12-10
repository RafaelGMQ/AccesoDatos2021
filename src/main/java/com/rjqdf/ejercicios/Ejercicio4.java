package com.rjqdf.ejercicios;

import javazoom.jl.player.Player;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.xml.bind.DatatypeConverter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ejercicio4 {

    public static void main(String[] args) {

        new File("output").mkdir();

//        apartado1();
//        apartado2();
//        apartado3();
//        apartado4();
//        apartado5();
//        apartado6();
        apartado7();
    }

    public static void apartado1() {

        try {

            // Input file (String) reading

            File inputFile = new File(".\\input\\himno_de_la_alegria.txt");
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            int readByte;
            StringBuilder hymn = new StringBuilder();
            while ((readByte = inputStreamReader.read()) != -1) {

                hymn.append((char) readByte);
            }

            inputStreamReader.close();


            // String - byte translation

            String[] namesOfMusicalNotes = {"SILENCIO", "DO", "RE", "MI", "FA", "SOL", "LA", "SI"};
            byte[] bytesOfMusicalNotes = {0b00000000, 0b00000001, 0b00000010, 0b00000011, 0b00000100,
                    0b00000101, 0b00000110, 0b00000111};

            String[] hymnStringNotes = hymn.toString().split(" ");
            byte[] hymnByteNotes = new byte[hymnStringNotes.length];

            for (int i = 0; i < hymnStringNotes.length; i++) {

                for (int j = 0; j < namesOfMusicalNotes.length; j++) {

                    if (hymnStringNotes[i].equals(namesOfMusicalNotes[j])) {

                        hymnByteNotes[i] = bytesOfMusicalNotes[j];
                    }
                }
            }


            // Output file (binary) writing

            File outputFile = new File(".\\output\\himno.notas");
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

            fileOutputStream.write(hymnByteNotes);

            fileOutputStream.close();


            // MD5 hash calculation

            File hashFile = new File(".\\output\\himno.hash");
            fileOutputStream = new FileOutputStream(hashFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(hymnByteNotes);
            String hash = DatatypeConverter.printHexBinary(messageDigest.digest()).toUpperCase();

            outputStreamWriter.write(hash);

            outputStreamWriter.close();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
    }

    public static void apartado2() {

        // Create '.\output\himno.notas' from '.\input\himno_de_la_alegria.txt'
        apartado1();

        try {

            // Input file (binary) reading

            File file = new File(".\\output\\himno.notas");
            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] inputFileBytes = new byte[fileInputStream.available()];
            fileInputStream.read(inputFileBytes);

            fileInputStream.close();


            // Print musical notes (String names) of read bytes

            int numberOfMusicalNotes = 0;
            String[] namesOfMusicalNotes = {"SILENCIO", "DO", "RE", "MI", "FA", "SOL", "LA", "SI"};

            for (byte binaryValue : inputFileBytes) {

                System.out.print(namesOfMusicalNotes[binaryValue] + " ");

                if (binaryValue != 0) {

                    numberOfMusicalNotes++;
                }
            }

            System.out.println("\n\nLa canción contiene " + numberOfMusicalNotes + " notas musicales (excluyendo los silencios).");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado3() {

        try{

            File file = new File(".\\input\\musica");
            FileInputStream fileInputStream = new FileInputStream(file);
            Player player = new Player(fileInputStream);

            player.play();

        }  catch(Exception e){

            e.printStackTrace();
        }
    }

    public static void apartado4() {

        try {

            // Input file (binary) reading

            File inputFile = new File(".\\input\\imagen");
            FileInputStream fileInputStream = new FileInputStream(inputFile);

            byte[] inputFileBytes = new byte[fileInputStream.available()];
            fileInputStream.read(inputFileBytes);

            fileInputStream.close();


            // Byte processing

            int imageWidth = 68;
            int imageHeight = 28;

            StringBuilder messageToWrite = new StringBuilder();

            for (int i = 0; i < imageHeight; i++) {

                for (int j = 0; j < imageWidth; j++) {

                    int inputFileByte = i * imageWidth + j;

                    switch (inputFileBytes[inputFileByte]) {

                        case 0b00000000:
                            messageToWrite.append('\u0020');
                            break;

                        case 0b00000001:
                            messageToWrite.append('\u002E');
                            break;

                        case 0b00000010:
                            messageToWrite.append('\u002C');
                            break;

                        case 0b00000011:
                            messageToWrite.append('\u003B');
                            break;

                        case 0b00000100:
                            messageToWrite.append('\u0025');
                            break;

                        case 0b00000101:
                            messageToWrite.append('\u002F');
                            break;

                        case 0b00000110:
                            messageToWrite.append('\u0040');
                            break;

                        case 0b00000111:
                            messageToWrite.append('\u0061');
                            break;

                        case 0b00001000:
                            // Compiler identifies '\u0027' as ''' which produces compile time error
                            messageToWrite.append('\'');
                            break;

                        case 0b00001001:
                            messageToWrite.append('\u0060');
                            break;

                        case 0b00001010:
                            messageToWrite.append('\u0053');
                            break;

                        case 0b00001011:
                            messageToWrite.append('\u0073');
                            break;

                        case 0b00001100:
                            messageToWrite.append('\u0030');
                            break;

                        default:
                            System.out.println("Carácter no identificado");
                    }
                }

                messageToWrite.append("\r\n");
            }


            // Output file (String) writing

            File outputFile = new File(".\\output\\imagen.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);

            outputStreamWriter.write(messageToWrite.toString());

            outputStreamWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado5() {

        try {

            // Input file (String) reading

            File inputFile = new File(".\\input\\mario.txt");
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            int readByte;
            StringBuilder fileContent = new StringBuilder();
            int imageWidth = 0;
            int imageHeight = 0;
            while ((readByte = inputStreamReader.read()) != -1) {

                if (readByte != '\r' && readByte != '\n') {

                    fileContent.append((char) readByte);
                    imageWidth++;

                } else {

                    if (readByte == '\n') {

                        imageHeight++;
                        imageWidth = 0;
                    }
                }
            }

            inputStreamReader.close();

            // Last two bytes in output file are the width and the height of the image
            int outputBytesSize = fileContent.length() + 2;
            byte[] outputBytes = new byte[outputBytesSize];
            // Be careful! width and height cannot be greater than 127
            outputBytes[outputBytesSize - 2] = (byte) imageWidth;
            outputBytes[outputBytesSize - 1] = (byte) imageHeight;


            // String - byte translation

            // Each position in array corresponds to the assigned byte
            char[] usedCharacters = {'B', 'N', 'R', 'C', 'A', 'M'};

            for (int i = 0; i < fileContent.length(); i++) {

                for (int j = 0; j < usedCharacters.length; j++) {

                    if (fileContent.charAt(i) == usedCharacters[j]) {

                        outputBytes[i] = (byte) j;
                    }
                }
            }


            // Output file (binary) writing

            File outputFile = new File(".\\output\\mario.bytes");
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

            fileOutputStream.write(outputBytes);

            fileOutputStream.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado6() {

        // Create '.\output\mario.bytes' from '.\input\mario.txt'
        apartado5();

        try {

            // Input file (binary) reading

            File file = new File(".\\output\\mario.bytes");
            FileInputStream fileInputStream = new FileInputStream(file);

            final byte[] inputFileBytes = new byte[fileInputStream.available()];
            fileInputStream.read(inputFileBytes);

            fileInputStream.close();


            // Represent image

            final int IMAGE_WIDTH = inputFileBytes[(int) (file.length() - 2)];
            final int IMAGE_HEIGHT = inputFileBytes[(int) (file.length() - 1)];
            final int PIXEL_SIZE = 10;

            JPanel jPanel = new JPanel() {

                @Override
                protected void paintComponent(Graphics g) {

                    super.paintComponent(g);

                    int totalPixels = inputFileBytes.length - 2;

                    for (int i = 0; i < totalPixels; i++) {

                        byte currentByte = inputFileBytes[i];

                        switch (currentByte) {

                            case 0b00000000:
                                g.setColor(Color.WHITE);
                                break;

                            case 0b00000001:
                                g.setColor(Color.BLACK);
                                break;

                            case 0b00000010:
                                g.setColor(Color.RED);
                                break;

                            case 0b00000011:
                                g.setColor(new Color(245, 235, 198));
                                break;

                            case 0b00000100:
                                g.setColor(Color.BLUE);
                                break;

                            case 0b00000101:
                                g.setColor(new Color(102, 51, 0));
                                break;
                        }

                        int sourcePoint = i;

                        int xPosition = (sourcePoint * PIXEL_SIZE) % (IMAGE_WIDTH * PIXEL_SIZE);

                        while ((sourcePoint * PIXEL_SIZE) % (IMAGE_WIDTH * PIXEL_SIZE) != 0) {

                            sourcePoint--;
                        }

                        int yPosition = (sourcePoint * PIXEL_SIZE) / IMAGE_WIDTH;

                        for (int y = 0; y < PIXEL_SIZE; y++) {

                            for (int x = 0; x < PIXEL_SIZE; x++) {


                                g.drawLine(xPosition + x, yPosition + y, xPosition + x, yPosition + y);
                            }
                        }
                    }
                }
            };

            JFrame jFrame = new JFrame();
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            int width = IMAGE_WIDTH * PIXEL_SIZE + 25;
            int height = IMAGE_HEIGHT * PIXEL_SIZE + 75;
            jFrame.setSize(width, height);
            jFrame.add(jPanel);
            jFrame.setVisible(true);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void apartado7() {

        try {

            final BufferedImage IMAGE = ImageIO.read(new File(".\\input\\foto"));

            JPanel jPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(IMAGE, 0, 0, null);
                }
            };

            JFrame jFrame = new JFrame();
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrame.setSize(IMAGE.getWidth(), IMAGE.getHeight());
            jFrame.add(jPanel);
            jFrame.setVisible(true);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
