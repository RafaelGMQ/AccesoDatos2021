package com.rjqdf.ejercicios.ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader {

    public static final int BUFFER_DEFAULT_SIZE = 8192;

    private FileReader fileReader;
    private char[] buffer;
    private int position;
    private int lastNumberOfCharactersRead;

    public BufferedReader(String filePath) throws FileNotFoundException {

        this(filePath, BUFFER_DEFAULT_SIZE);
    }

    public BufferedReader(String filePath, int bufferSize) throws FileNotFoundException {

        File inputFile = new File(filePath);
        fileReader = new FileReader(inputFile);
        buffer = new char[bufferSize];
    }

    public String readLine() throws IOException {

        char currentCharacter;
        boolean iterate = true;
        boolean positionOverflow;
        StringBuilder line = new StringBuilder();

        do {

            if (position % buffer.length == 0) {

                lastNumberOfCharactersRead = fileReader.read(buffer);
                position = 0;
            }

            currentCharacter = buffer[position++];

            positionOverflow = position > lastNumberOfCharactersRead;

            if (currentCharacter == '\r') {

                // Do nothing because new-line-characters has not to be added.
                // In addition, if a '\r' character is found, the loop has to continue
                // iterating because next character has to be '\n'.

            } else if (currentCharacter == '\n' || positionOverflow) {

                iterate = false;

            } else {

                line.append(currentCharacter);
            }

        } while (iterate);

        if (positionOverflow && line.length() == 0) {

            return null;
        }

        return line.toString();
    }

    public void close() throws IOException {

        this.fileReader.close();
    }
}
