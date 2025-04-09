package utn.dds.tp1.dominio;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Materia {
    private String codigo;
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String codigo, String nombre, List<Materia> correlativas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correlativas = Objects.requireNonNullElseGet(correlativas, List::of);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Materia materia))
            return false;

        return Objects.equals(codigo, materia.codigo);
    }
}
