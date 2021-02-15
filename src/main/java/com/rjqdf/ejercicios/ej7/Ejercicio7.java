package com.rjqdf.ejercicios.ej7;

import com.rjqdf.ejercicios.ej7.dao.BaseDeDatos;
import com.rjqdf.ejercicios.ej7.dominio.Alumno;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {

//        apartado1();
//        apartado2();
        apartado3();

//        borrarTablaAlumnos();
    }

    private static void apartado1() {

        try {

            File file = new File("output\\alumnos.xml");

            // Parsear XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            // Generar lista de Alumnos
            NodeList listaNodosAlumno = document.getDocumentElement().getChildNodes();
            List<Alumno> alumnos = new ArrayList<>();

            for(int i = 0; i < listaNodosAlumno.getLength(); i++) {

                Node node = listaNodosAlumno.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element nodoAlumno = (Element) node;

                    Alumno alumno = new Alumno(
                            Integer.parseInt(nodoAlumno.getAttribute("id")),
                            nodoAlumno.getElementsByTagName("nombre").item(0).getTextContent(),
                            nodoAlumno.getElementsByTagName("apellidos").item(0).getTextContent(),
                            nodoAlumno.getElementsByTagName("grupo").item(0).getTextContent(),
                            nodoAlumno.getElementsByTagName("fecha_nacimiento").item(0).getTextContent(),
                            Integer.parseInt(nodoAlumno.getElementsByTagName("curso").item(0).getTextContent())
                    );

                    alumnos.add(alumno);
                }
            }

            // Conectar con la BBDD
            String url = "jdbc:mysql://localhost:3306/accesodatos?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(url, "root", "root");

            // Crear tabla de alumnos
            crearTablaAlumnos();

            // Insertar alumnos en la tabla
            String query = "INSERT INTO alumnos (`id`, `nombre`, `apellidos`, `grupo`, `fecha_nacimiento`, `curso`) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            for (Alumno a : alumnos) {

                preparedStatement.setInt(1, a.getId());
                preparedStatement.setString(2, a.getNombre());
                preparedStatement.setString(3, a.getApellidos());
                preparedStatement.setString(4, a.getGrupo());
                preparedStatement.setDate(5, new Date(a.getFechaNacimiento().getTime()));
                preparedStatement.setInt(6, a.getCurso());
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private static void crearTablaAlumnos() {

        try {

            String url = "jdbc:mysql://localhost:3306/accesodatos?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(url, "root", "root");

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE `accesodatos`.`alumnos` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `nombre` VARCHAR(45) NOT NULL,\n" +
                    "  `apellidos` VARCHAR(45) NOT NULL,\n" +
                    "  `grupo` VARCHAR(45) NOT NULL,\n" +
                    "  `fecha_nacimiento` DATE NOT NULL,\n" +
                    "  `curso` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            statement.executeUpdate(sql);

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void borrarTablaAlumnos() {

        try {

            String url = "jdbc:mysql://localhost:3306/accesodatos?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(url, "root", "root");

            Statement statement = connection.createStatement();
            String sql = "DROP TABLE `accesodatos`.`alumnos`;";
            statement.executeUpdate(sql);

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void apartado2() {

        BaseDeDatos baseDeDatos = new BaseDeDatos();

        // Imprimir toda la tabla alumnos de la BBDD
//        imprimirTablaAlumnos();

        // Crear un alumno
//        baseDeDatos.crearAlumno(new Alumno(0, "Rafael", "Quintana", "DAM", "01/01/2000", 2));

        // Imprimir toda la tabla alumnos de la BBDD
//        imprimirTablaAlumnos();

        // Buscar un alumno específico (por id)
//        System.out.println(baseDeDatos.buscarAlumnoPorId(25));

        // Buscar alumnos a partir de un apellido
//        List<Alumno> alumnosDiaz = baseDeDatos.buscarAlumnoPorApellido("Díaz");
//        for (Alumno a : alumnosDiaz) {
//
//            System.out.println(a);
//        }

        // Actualizar un alumno
//        baseDeDatos.actualizarAlumno(101, new Alumno(101, "Rafael Jesús", "Quintana", "DAM", "01/01/2000", 2));

        // Imprimir toda la tabla alumnos de la BBDD
//        imprimirTablaAlumnos();

        // Borrar un alumno
//        baseDeDatos.borrarAlumno(101);

        // Imprimir toda la tabla alumnos de la BBDD
//        imprimirTablaAlumnos();
    }

    private static void imprimirTablaAlumnos() {

        BaseDeDatos baseDeDatos = new BaseDeDatos();
        List<Alumno> todosLosAlumnos = baseDeDatos.buscarTodosLosAlumnos();

        for (Alumno a : todosLosAlumnos) {

            System.out.println(a);
        }
    }

    private static void apartado3() {

        BaseDeDatos baseDeDatos = new BaseDeDatos();

        int opcion;

        do {

            System.out.println();
            System.out.println("Seleccione una de las siguientes opciones:");
            System.out.println("[1] Mostrar todos los alumnos");
            System.out.println("[2] Mostrar alumno por id");
            System.out.println("[3] Mostrar alumno por apellidos");
            System.out.println("[4] Crear alumno");
            System.out.println("[5] Actualizar alumno");
            System.out.println("[6] Eliminar alumno");
            System.out.println("[7] SALIR");
            System.out.println();

            opcion = solicitarEnteroEntreDosNumeros(1, 7);

            switch (opcion) {

                case 1: // Mostrar todos los alumnos

                    List<Alumno> todosLosAlumnos = baseDeDatos.buscarTodosLosAlumnos();

                    if (todosLosAlumnos.isEmpty()) {

                        System.out.println();
                        System.out.println("No hay ningún alumno en la base de datos...");

                    } else {

                        for (Alumno a : todosLosAlumnos) {

                            System.out.println();
                            System.out.println(a.toTxt());
                        }
                    }
                    break;

                case 2: // Mostrar alumno por id

                    Alumno alumno = baseDeDatos.buscarAlumnoPorId(solicitarId());
                    System.out.println();

                    if (alumno != null) {

                        System.out.println(alumno.toTxt());

                    } else {

                        System.out.println("No se ha encontrado ningún alumno con ese ID...");
                    }
                    break;

                case 3: // Mostrar alumno por apellidos

                    List<Alumno> alumnos = baseDeDatos.buscarAlumnoPorApellido(solicitarApellidos());

                    if (alumnos.isEmpty()) {

                        System.out.println();
                        System.out.println("No hay ningún alumno con esos apellidos en la base de datos...");

                    } else {

                        for (Alumno a : alumnos) {

                            System.out.println();
                            System.out.println(a.toTxt());
                        }
                    }
                    break;

                case 4: // Crear alumno

                    int idAlumnoCreado = baseDeDatos.crearAlumno(solicitarAlumno());

                    System.out.println();

                    if (idAlumnoCreado == -1) {

                        System.out.println("Ha habido un problema tratando de insertar el alumno en la base de datos...");

                    } else {

                        System.out.println("Se ha creado correctamente un alumno con id = " + idAlumnoCreado);
                    }
                    break;

                case 5: // Actualizar alumno

                    int idAlumnoActualizado = baseDeDatos.actualizarAlumno(solicitarId(), solicitarAlumno());
                    System.out.println();

                    switch (idAlumnoActualizado) {

                        case -1:
                            System.out.println("Ha habido un problema tratando de actualizar el alumno en la base de datos...");
                            break;

                        case 0:
                            System.out.println("No se ha encontrado ningún alumno con ese ID...");
                            break;

                        case 1:

                            System.out.println("Se ha actualizado correctamente el alumno en la base de datos");
                            break;

                        default:

                            System.out.println("¡CUIDADO! Se ha actualizado más de un alumno en la base de datos...");
                    }
                    break;

                case 6: // Eliminar alumno

                    int idAlumnoEliminado = baseDeDatos.borrarAlumno(solicitarId());
                    System.out.println();

                    switch (idAlumnoEliminado) {

                        case -1:
                            System.out.println("Ha habido un problema tratando de eliminar el alumno de la base de datos...");
                            break;

                        case 0:
                            System.out.println("No se ha encontrado ningún alumno con ese ID...");
                            break;

                        case 1:

                            System.out.println("Se ha eliminado correctamente el alumno de la base de datos");
                            break;

                        default:

                            System.out.println("¡CUIDADO! Se ha eliminado más de un alumno de la base de datos...");
                    }
                    break;
            }

        } while (opcion != 7);
    }

    private static int solicitarEnteroEntreDosNumeros(int limiteInferior, int limiteSuperior) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Opción: ");

        int opcion;

        try {

            opcion = scanner.nextInt();

            if (opcion < limiteInferior || opcion > limiteSuperior) {

                System.out.println("Por favor, seleccione un número entre " + limiteInferior + " y " + limiteSuperior);
                opcion = solicitarEnteroEntreDosNumeros(limiteInferior, limiteSuperior);
            }

        } catch (InputMismatchException e) {

            scanner.next();
            System.out.println("La opción seleccionada no es válida...");
            opcion = solicitarEnteroEntreDosNumeros(limiteInferior, limiteSuperior);
        }

        return opcion;
    }

    private static int solicitarId() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Indique el ID: ");

        int opcion;

        try {

            opcion = scanner.nextInt();

        } catch (InputMismatchException e) {

            scanner.next();
            System.out.println("El ID introducido no es válido...");
            opcion = solicitarId();
        }

        return opcion;
    }

    private static String solicitarNombre() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Indique el nombre: ");

        String nombre;

        try {

            nombre = scanner.nextLine();

        } catch (InputMismatchException e) {

            scanner.next();
            System.out.println("No se reconoce la opción introducida...");
            nombre = solicitarNombre();
        }

        return nombre;
    }

    private static String solicitarApellidos() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Indique los apellidos: ");

        String apellidos;

        try {

            apellidos = scanner.nextLine();

        } catch (InputMismatchException e) {

            scanner.next();
            System.out.println("No se reconoce la opción introducida...");
            apellidos = solicitarApellidos();
        }

        return apellidos;
    }

    private static String solicitarGrupo() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Indique el grupo: ");

        String grupo;

        try {

            grupo = scanner.nextLine();

        } catch (InputMismatchException e) {

            scanner.next();
            System.out.println("No se reconoce la opción introducida...");
            grupo = solicitarGrupo();
        }

        return grupo;
    }

    private static String solicitarFechaDeNacimiento() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Indique la fecha de nacimiento (DD/MM/YYYY): ");

        String fechaDeNacimiento;

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            fechaDeNacimiento = scanner.nextLine();
            dateFormat.parse(fechaDeNacimiento);

        } catch (ParseException e) {

            System.out.println("El formato de la fecha introducida no es válido...");
            fechaDeNacimiento = solicitarFechaDeNacimiento();

        } catch (InputMismatchException e) {

            scanner.next();
            System.out.println("No se reconoce la opción introducida...");
            fechaDeNacimiento = solicitarFechaDeNacimiento();
        }

        return fechaDeNacimiento;
    }

    private static int solicitarCurso() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Indique el curso: ");

        int opcion;

        try {

            opcion = scanner.nextInt();

        } catch (InputMismatchException e) {

            scanner.next();
            System.out.println("El curso introducido no es válido...");
            opcion = solicitarCurso();
        }

        return opcion;
    }

    private static Alumno solicitarAlumno() {

        return new Alumno(0, solicitarNombre(), solicitarApellidos(), solicitarGrupo(), solicitarFechaDeNacimiento(), solicitarCurso());
    }
}
