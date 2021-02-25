package com.rjqdf.ejercicios.ej8.dao;

import com.rjqdf.ejercicios.ej8.dominio.Alumno;

import java.util.List;

public interface BaseDeDatos {

    List<Alumno> buscarTodosLosAlumnos();

    Alumno buscarAlumnoPorId(int id);

    List<Alumno> buscarAlumnoPorApellido(String apellido);

    Alumno obtenerUltimoAlumno();

    int crearAlumno(Alumno alumno);

    int actualizarAlumno(int id, Alumno alumno);

    int borrarAlumno(int id);
}
