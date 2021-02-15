package com.rjqdf.ejercicios.ej7.dao;

import com.rjqdf.ejercicios.ej7.dominio.Alumno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    private Connection connection;

    public BaseDeDatos() {

        try {

            String url = "jdbc:mysql://localhost:3306/accesodatos?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "root");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /*
     * Devuelve una lista con todos los alumnos o null si hay un error en la búsqueda
     */
    public List<Alumno> buscarTodosLosAlumnos() {

        String query = "SELECT * FROM alumnos";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Alumno> alumnos = new ArrayList<>();

            while (resultSet.next()) {

                alumnos.add(new Alumno(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getInt(6)));
            }

            return alumnos;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    /*
     * Devuelve el alumno cuyo ID coincide con el recibido como parámetro o null si hay un error en la búsqueda
     */
    public Alumno buscarAlumnoPorId(int id) {

        String query = "SELECT * FROM alumnos WHERE id = ?";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new Alumno(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getInt(6));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    /*
     * Devuelve la lista de alumnos con apellidos contenidos en el string recibido como parámetro o null si hay un error en la búsqueda
     */
    public List<Alumno> buscarAlumnoPorApellido(String apellido) {

        String query = "SELECT * FROM alumnos WHERE apellidos LIKE ?";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + apellido + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Alumno> alumnos = new ArrayList<>();

            while (resultSet.next()) {

                alumnos.add(new Alumno(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getInt(6)));
            }

            return alumnos;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    /*
     * Devuelve el último alumno de la tabla o null si hay un error en la búsqueda
     */
    public Alumno obtenerUltimoAlumno() {

        String query = "SELECT * FROM alumnos ORDER BY id DESC LIMIT 1";

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                return new Alumno(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getInt(6));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    /*
     * Devuelve el id del alumno insertado si se ha realizado la inserción correctamente y -1 en caso contrario
     */
    public int crearAlumno(Alumno alumno) {

        String query = "INSERT INTO alumnos (`nombre`, `apellidos`, `grupo`, `fecha_nacimiento`, `curso`) VALUES (?, ?, ?, ?, ?)";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, alumno.getNombre());
            preparedStatement.setString(2, alumno.getApellidos());
            preparedStatement.setString(3, alumno.getGrupo());
            Date fechaNacimiento = new Date(alumno.getFechaNacimiento().getTime() + 10000000); // Hay que añadir unas horas para que coja la fecha bien
            preparedStatement.setDate(4, fechaNacimiento);
            preparedStatement.setInt(5, alumno.getCurso());

            int inserciones = preparedStatement.executeUpdate();

            if (inserciones == 1) {

                return obtenerUltimoAlumno().getId();

            } else {

                return -1;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return -1;
    }

    /*
     * Devuelve:
     * 1 si se ha realizado la actualización correctamente
     * 0 si en la base de datos no existe ningún alumno con el id recibido
     * -1 en caso de que se produzca algún error al intentar actualizar
     */
    public int actualizarAlumno(int id, Alumno alumno) {

        String query = "UPDATE alumnos SET `nombre` = ?, `apellidos` = ?, `grupo` = ?, `fecha_nacimiento` = ?, `curso` = ? WHERE `id` = ?";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, alumno.getNombre());
            preparedStatement.setString(2, alumno.getApellidos());
            preparedStatement.setString(3, alumno.getGrupo());

            Date fechaNacimiento = new Date(alumno.getFechaNacimiento().getTime() + 10000000); // Hay que añadir unas horas para que coja la fecha bien
            preparedStatement.setDate(4, fechaNacimiento);
            preparedStatement.setInt(5, alumno.getCurso());
            preparedStatement.setInt(6, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return -1;
    }

    /*
     * Devuelve:
     * 1 si se ha realizado el borrado correctamente
     * 0 si en la base de datos no existe ningún alumno con el id recibido
     * -1 en caso de que se produzca un error al intentar borrar
     */
    public int borrarAlumno(int id) {

        String query = "DELETE FROM alumnos WHERE `id` = ?";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return -1;
    }
}
