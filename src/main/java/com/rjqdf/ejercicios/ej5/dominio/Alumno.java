package com.rjqdf.ejercicios.ej5.dominio;

public class Alumno {

    private int id;
    private String nombre;
    private String apellidos;
    private String grupo;
    private String fechaNacimiento;

    public Alumno() {}

    public Alumno(int id, String nombre, String apellidos, String grupo, String fechaNacimiento) {

        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.grupo = grupo;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", grupo='" + grupo + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }

    public String toTxt() {

        return "id: " + id + "\r\n"
                + "nombre: " + nombre + "\r\n"
                + "apellidos: " + apellidos + "\r\n"
                + "grupo: " + grupo + "\r\n"
                + "fecha de nacimiento: " + fechaNacimiento;
    }
}
