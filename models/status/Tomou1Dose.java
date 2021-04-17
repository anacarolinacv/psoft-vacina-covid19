package models.status;

import java.util.Objects;

public class Tomou1Dose implements StatusVacina{
    private String tipo;

    public Tomou1Dose() {
        this.tipo = "1 DOSE APLICADA";
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tomou1Dose that = (Tomou1Dose) o;
        return tipo.equals(that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}
