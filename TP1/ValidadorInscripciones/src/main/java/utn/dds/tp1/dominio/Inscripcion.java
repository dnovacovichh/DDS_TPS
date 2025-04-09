package utn.dds.tp1.dominio;

import lombok.Getter;

import java.util.List;

@Getter
public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public boolean aprobada() {
        return materias.stream().allMatch(this::correlativasAprobadas);
    }

    private boolean correlativasAprobadas(Materia materia) {
        return materia.getCorrelativas()
                .stream()
                .allMatch(correlativa -> alumno.aprobo(correlativa));
    }
}