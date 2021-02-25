package com.rjqdf.ejercicios.ej8.dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alumno {

    private int id;
    private String nombre;
    private String apellidos;
    private String grupo;
    private Date fechaNacimiento;
    private int curso;

    public Alumno() {}

    public Alumno(int id, String nombre, String apellidos, String grupo, Date fechaNacimiento, int curso) {

        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.grupo = grupo;
        this.fechaNacimiento = fechaNacimiento;
        this.curso = curso;
    }

    public Alumno(int id, String nombre, String apellidos, String grupo, String fechaNacimiento, int curso) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.grupo = grupo;
        this.curso = curso;

        try {

            this.fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);

        } catch (ParseException e) {

            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", grupo='" + grupo + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }

    public String toTxt() {

        return "id: " + id + "\r\n"
                + "nombre: " + nombre + "\r\n"
                + "apellidos: " + apellidos + "\r\n"
                + "grupo: " + grupo + "\r\n"
                + "fecha de nacimiento: " + fechaNacimiento + "\r\n"
                + "curso: " + curso;
    }
}
