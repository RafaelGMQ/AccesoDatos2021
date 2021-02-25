package com.rjqdf.ejercicios.ej8.dao.impl;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.rjqdf.ejercicios.ej8.dao.BaseDeDatos;
import com.rjqdf.ejercicios.ej8.dominio.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatosHibernate implements BaseDeDatos {

    private SessionFactory factory;

    public BaseDeDatosHibernate() {

        // Dehabilita el log de los datos de conexión
        ((LoggerContext) LoggerFactory.getILoggerFactory()).getLogger("org.hibernate").setLevel(Level.ERROR);

        try {

            factory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable e) {

            throw new ExceptionInInitializerError(e);
        }
    }

    /*
     * Devuelve una lista con todos los alumnos
     */
    public List<Alumno> buscarTodosLosAlumnos() {

        Session session = factory.openSession();
        List<Alumno> alumnos = session.createQuery("from Alumno").list(); // OJO! Es el nombre de la clase (en mayúscula), no el nombre de la tabla
        session.close();

        return alumnos;
    }

    /*
     * Devuelve el alumno cuyo ID coincide con el recibido como parámetro o null si no se encuentra un alumno con el id recibido
     */
    public Alumno buscarAlumnoPorId(int id) {

        Session session = factory.openSession();
        Alumno alumno = session.get(Alumno.class, id);
        session.close();

        return alumno;
    }

    /*
     * Devuelve la lista de alumnos con apellidos contenidos en el string recibido como parámetro
     */
    public List<Alumno> buscarAlumnoPorApellido(String apellido) {

        Session session = factory.openSession();
        List<Alumno> alumnos = session.createQuery("from Alumno").list();
        session.close();

        List<Alumno> resultado = new ArrayList<>();

        for (Alumno a : alumnos) {
            if (a.getApellidos().contains(apellido)){
                resultado.add(a);
            }
        }

        return resultado;
    }

    /*
     * Devuelve el último alumno de la tabla
     */
    public Alumno obtenerUltimoAlumno() {

        Session session = factory.openSession();
        List<Alumno> alumnos = session.createQuery("from Alumno").list();
        session.close();

        return alumnos.get(alumnos.size() - 1);
    }

    /*
     * Devuelve el id del alumno insertado si se ha realizado la inserción correctamente
     */
    public int crearAlumno(Alumno alumno) {

        Session session = factory.openSession();
        int idNuevoAlumno = (Integer) session.save(alumno);
        session.close();

        return idNuevoAlumno;
    }

    /*
     * Devuelve:
     * 1 si se ha realizado la actualización correctamente
     * 0 si en la base de datos no existe ningún alumno con el id recibido
     */
    public int actualizarAlumno(int id, Alumno alumno) {

        Session session = factory.openSession();
        Alumno alumnoAntiguo = session.get(Alumno.class, id);
        int retorno = 0;

        if (alumnoAntiguo != null) {

            // Para que los cambios se realicen es necesario utilizar un Transaction
            Transaction transaction = session.beginTransaction();

            alumnoAntiguo.setNombre(alumno.getNombre());
            alumnoAntiguo.setApellidos(alumno.getApellidos());
            alumnoAntiguo.setGrupo(alumno.getGrupo());
            alumnoAntiguo.setFechaNacimiento(alumno.getFechaNacimiento());

            session.update(alumnoAntiguo);
            transaction.commit();

            retorno = 1;
        }

        session.close();
        return retorno;
    }

    /*
     * Devuelve:
     * 1 si se ha realizado el borrado correctamente
     * 0 si en la base de datos no existe ningún alumno con el id recibido
     */
    public int borrarAlumno(int id) {

        Session session = factory.openSession();
        Alumno alumno = session.get(Alumno.class, id);
        int retorno = 0;

        if (alumno != null){

            // Para que los cambios se realicen es necesario utilizar un Transaction
            Transaction transaction = session.beginTransaction();

            session.delete(alumno);
            transaction.commit();

            retorno = 1;
        }

        session.close();
        return retorno;
    }
}
