package models.status;

import java.util.Objects;

public class NaoHabilitada implements StatusVacina {

    private String tipo;

    public NaoHabilitada() {
        this.tipo = "NAO HABILITADA";
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NaoHabilitada that = (NaoHabilitada) o;
        return tipo.equals(that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}
