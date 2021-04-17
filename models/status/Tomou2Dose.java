package models.status;

import java.util.Objects;

public class Tomou2Dose implements StatusVacina{

    private String tipo;

    public Tomou2Dose() {
        this.tipo = "2 DOSE APLICADA";
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tomou2Dose that = (Tomou2Dose) o;
        return tipo.equals(that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}
