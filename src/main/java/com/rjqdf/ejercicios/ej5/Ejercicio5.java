package com.rjqdf.ejercicios.ej5;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ejercicio5 {


    public static void main(String[] args) {

        apartado4();
    }

    public static void apartado1() {

        String[] nombres = {"Lucía", "María", "Martina", "Paula", "Sofía", "Daniela", "Alba", "Julia", "Carla", "Sara", "Valeria", "Noa", "Emma", "Claudia", "Carmen", "Valentina", "Ana", "Marta", "Irene", "Adriana", "Laura", "Elena", "Alejandra", "Vega", "Alma", "Laia", "Lola", "Vera", "Olivia", "Inés", "Aitana", "Jimena", "Candela", "Ariadna", "Carlota", "Ainhoa", "Nora", "Triana", "Marina", "Chloe", "Elsa", "Alicia", "Clara", "Blanca", "Leire", "Mía", "Lara", "Rocío", "Ainara", "Nerea", "Hugo", "Daniel", "Pablo", "Martín", "Alejandro", "Adrián", "Álvaro", "David", "Lucas", "Mateo", "Mario", "Manuel", "Antonio", "Diego", "Leo", "Javier", "Marcos", "Izan", "Alex", "Sergio", "Enzo", "Carlos", "Marc", "Jorge", "Miguel", "Gonzalo", "Juan", "Ángel", "Oliver", "Iker", "Dylan", "Bruno", "Eric", "Marco", "Iván", "Nicolás", "José", "Héctor", "Darío", "Samuel", "Víctor", "Rubén", "Gabriel", "Adam", "Aaron", "Thiago", "Jesús", "Aitor", "Alberto", "Guillermo"};
        String[] apellidos = {"García", "González", "Rodríguez", "Fernández", "López", "Martínez", "Sánchez", "Pérez", "Gómez", "Martín", "Jiménez", "Ruíz", "Hernández", "Díaz", "Moreno", "Muñoz", "Álvarez", "Romero", "Alonso", "Gutiérrez", "Navarro", "Torres", "Domínguez", "Vázquez", "Ramos", "Gil", "Ramírez", "Serrano", "Blanco", "Molina", "Morales", "Suárez", "Ortega", "Delgado", "Castro", "Ortiz", "Rubio", "Marín", "Sanz", "Núñez", "Iglesias", "Medina", "Garrido", "Cortes", "Castillo", "Santos", "Lozano", "Guerrero", "Cano", "Prieto", "Méndez", "Cruz", "Calvo", "Gallego", "Vidal", "León", "Márquez", "Herrera", "Peña", "Flores", "Cabrera", "Campos", "Vega", "Fuentes", "Carrasco", "Díez", "Caballero", "Reyes", "Nieto", "Aguilar", "Pascual", "Santana", "Herrero", "Lorenzo", "Montero", "Hidalgo", "Ibáñez", "Ferrer", "Durán", "Santiago", "Benítez", "Mora", "Vicente", "Vargas", "Arias", "Carmona", "Crespo", "Román", "Pastor", "Soto", "Sáez", "Velasco", "Moya", "Soler", "Parra", "Esteban", "Bravo", "Gallardo", "Rojas", "Casado"};
        String[] grupos = {"DAM", "ASIR", "SMR"};

        try {

            File file = new File(".\\output\\alumnos.xml");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            bufferedWriter.write("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            bufferedWriter.write("<alumnos>\r\n");

            for (int i = 1; i <= 100; i++) {

                bufferedWriter.write("\t<alumno id=\"" + i + "\">\r\n");
                bufferedWriter.write("\t\t<nombre>" + nombres[(int) (Math.random() * nombres.length)] + "</nombre>\r\n");
                bufferedWriter.write("\t\t<apellidos>" + apellidos[(int) (Math.random() * apellidos.length)]
                        + " " + apellidos[(int) (Math.random() * apellidos.length)] + "</apellidos>\r\n");
                bufferedWriter.write("\t\t<grupo>" + grupos[(int) (Math.random() * grupos.length)] + "</grupo>\r\n");
                bufferedWriter.write("\t\t<fecha_nacimiento>" + obtenerFechaAleatoria() + "</fecha_nacimiento>\r\n");
                bufferedWriter.write("\t</alumno>\r\n");
                bufferedWriter.write("\r\n");
            }

            bufferedWriter.write("</alumnos>");

            bufferedWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String obtenerFechaAleatoria() {

        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            long milisegundosIniciales = simpleDateFormat.parse("01/01/1980").getTime();
            long milisegundosFinales = simpleDateFormat.parse("31/12/2000").getTime();

            long rangoFechas = milisegundosFinales - milisegundosIniciales;

            long numeroAleatorio = (long) (Math.random() * rangoFechas + milisegundosIniciales);


            Date fechaAleatoria = new Date(numeroAleatorio);

            return simpleDateFormat.format(fechaAleatoria);

        } catch (ParseException e) {

            e.printStackTrace();
        }

        return "ERROR al generar una fecha aleatoria";
    }

    public static List<Alumno> apartado2() {

        apartado1();

        List<Alumno> listaAlumnos = new ArrayList<>();

        try {

            File file = new File(".\\output\\alumnos.xml");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            Alumno alumno = null;
            while ((line = bufferedReader.readLine()) != null){


                if (line.contains("alumno id")) {

                    alumno = new Alumno();
                    int inicio = line.indexOf("\"") + 1;
                    int fin = line.indexOf("\"", inicio);
                    alumno.setId(Integer.parseInt(line.substring(inicio, fin)));

                } else if (line.contains("nombre")) {

                    int inicio = line.indexOf(">") + 1;
                    int fin = line.indexOf("<", inicio);
                    alumno.setNombre(line.substring(inicio, fin));

                } else if (line.contains("apellidos")) {

                    int inicio = line.indexOf(">") + 1;
                    int fin = line.indexOf("<", inicio);
                    alumno.setApellidos(line.substring(inicio, fin));

                } else if (line.contains("grupo")) {

                    int inicio = line.indexOf(">") + 1;
                    int fin = line.indexOf("<", inicio);
                    alumno.setGrupo(line.substring(inicio, fin));

                } else if (line.contains("fecha_nacimiento")) {

                    int inicio = line.indexOf(">") + 1;
                    int fin = line.indexOf("<", inicio);
                    alumno.setFechaNacimiento(line.substring(inicio, fin));
                    listaAlumnos.add(alumno);
                }
            }

            bufferedReader.close();

            for (Alumno a : listaAlumnos) {

                System.out.println(a);
            }

            return listaAlumnos;

        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }

    public static void apartado3() {

        List<Alumno> listaAlumnos = apartado2();

        File directorioDam = new File("output\\ej5\\DAM\\nombres");
        directorioDam.mkdirs();
        File directorioAsir = new File("output\\ej5\\ASIR\\nombres");
        directorioAsir.mkdirs();
        File directorioSmr = new File("output\\ej5\\SMR\\nombres");
        directorioSmr.mkdirs();


        for (Alumno a : listaAlumnos) {

            try {

                String fileName = a.getApellidos() + ", " + a.getNombre() + ".txt";
                File file = new File(".\\output\\ej5\\" + a.getGrupo() + "\\nombres\\" + fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

                bufferedWriter.write(a.toTxt());

                bufferedWriter.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    public static void apartado4() {

        List<Alumno> listaAlumnos = apartado2();

        File directorioDam = new File("output\\ej5\\DAM\\ids");
        directorioDam.mkdirs();
        File directorioAsir = new File("output\\ej5\\ASIR\\ids");
        directorioAsir.mkdirs();
        File directorioSmr = new File("output\\ej5\\SMR\\ids");
        directorioSmr.mkdirs();


        for (Alumno a : listaAlumnos) {

            try {

                String fileName = a.getId() + ".txt";
                File file = new File(".\\output\\ej5\\" + a.getGrupo() + "\\ids\\" + fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

                bufferedWriter.write(a.toTxt());

                bufferedWriter.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}
