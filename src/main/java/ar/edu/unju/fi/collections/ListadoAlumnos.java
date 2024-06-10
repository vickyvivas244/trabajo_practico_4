package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumnos {
    
    public static List<Alumno> alumnos = new ArrayList<Alumno>();

    // Método para listar alumnos
    public static List<Alumno> listarAlumnos() {
        return alumnos;
    }

    // Método para buscar un alumno por DNI
    public static Alumno buscarAlumnoPorDni(String dni) {
        for (Alumno a : alumnos) {
            if (a.getDni().equals(dni)) {
                return a;
            }
        }
        return null;
    }

    // Método para agregar un alumno
    public static void agregarAlumno(Alumno a) {
        alumnos.add(a);
    }

    // Método para modificar un alumno
    public static void modificarAlumno(Alumno alumnoModificado) {
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno alumno = alumnos.get(i);
            if (alumno.getDni().equals(alumnoModificado.getDni())) {
                alumnos.set(i, alumnoModificado);
                break;
            }
        }
    }

    // Método para eliminar un alumno
    public static void eliminarAlumno(String dni) {
        alumnos.removeIf(alumno -> alumno.getDni().equals(dni));
    }
}