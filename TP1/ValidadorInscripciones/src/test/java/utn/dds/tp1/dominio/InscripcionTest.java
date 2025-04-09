package utn.dds.tp1.dominio;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InscripcionTest {
    @Test
    public void aprobada_conMateriasSinCorrelativas_retornaTrue() {
        // Dado
        Alumno alumno = new Alumno();
        Materia materia1 = new Materia("Z1", "Matematica",null);
        Materia materia2 = new Materia("Z2", "Fisica", null);

        Inscripcion inscripcion = new Inscripcion(alumno, List.of(materia1, materia2));
        // Cuando
        var resultadoInscripcion = inscripcion.aprobada();
        // Entonces
        assertTrue(resultadoInscripcion);
    }

    @Test
    public void aprobada_conCorrelativasNoAprobadas_retornaFalse() {
        // Dado
        Alumno alumno = new Alumno();
        Materia correlativa = new Materia("K1", "Análisis de sistemas",null);
        Materia materiaAInscribir = new Materia("K2", "Diseño de Sistemas", List.of(correlativa));

        Inscripcion inscripcion = new Inscripcion(alumno, List.of(materiaAInscribir));
        // Cuando
        var resultadoInscripcion = inscripcion.aprobada();
        // Entonces
        assertFalse(resultadoInscripcion);
    }

    @Test
    public void aprobada_conCorrelativasAprobadas_retornaTrue() {
        // Dado
        Materia correlativa = new Materia("K1", "Análisis de sistemas",null);
        Materia materiaAInscribir = new Materia("K2", "Diseño de Sistemas", List.of(correlativa));

        Alumno alumno = new Alumno(List.of(correlativa));

        Inscripcion inscripcion = new Inscripcion(alumno, List.of(materiaAInscribir));
        // Cuando
        var resultadoInscripcion = inscripcion.aprobada();
        // Entonces
        assertTrue(resultadoInscripcion);
    }

    @Test
    public void aprobada_conCorrelativasYSinCorrelativas_todoAprobado_retornaTrue() {
        // Dado
        Materia correlativa = new Materia("K1", "Análisis de sistemas",null);
        Materia materiaAInscribirConCorrelativa = new Materia("K2", "Diseño de Sistemas", List.of(correlativa));
        Materia materiaAInscribirSinCorrelativa = new Materia("Z1", "Física", List.of(correlativa));

        Alumno alumno = new Alumno(List.of(correlativa));

        Inscripcion inscripcion = new Inscripcion(alumno, List.of(materiaAInscribirConCorrelativa,materiaAInscribirSinCorrelativa));
        // Cuando
        var resultadoInscripcion = inscripcion.aprobada();
        // Entonces
        assertTrue(resultadoInscripcion);
    }
}
