package utn.dds.tp1.dominio;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Alumno {
    private final List<Materia> materiasAprobadas;

    public Alumno() {
        this.materiasAprobadas = new ArrayList<>();
    }

    public Alumno(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public boolean aprobo(Materia materia) {
        return materiasAprobadas.contains(materia);
    }
}