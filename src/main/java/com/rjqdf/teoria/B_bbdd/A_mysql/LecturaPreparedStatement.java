package com.rjqdf.teoria.B_bbdd.A_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LecturaPreparedStatement {

    private static Connection connection;

    public static void main(String[] args) {

        try {

            conectarBbdd();

            String query = "SELECT * FROM alumnos WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 10);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                System.out.println("ID: " + resultSet.getInt(1));
                System.out.println("Nombre: " + resultSet.getString(2));
                System.out.println("Apellidos: " + resultSet.getString(3));
                System.out.println("Grupo: " + resultSet.getString(4));
                System.out.println("Fecha de nacimiento: " + resultSet.getString(5));
                System.out.println();
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    private static void conectarBbdd() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/accesodatos?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        connection = DriverManager.getConnection(url, "root", "root");
    }
}
