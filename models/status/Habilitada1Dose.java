package models.status;

import java.util.Objects;

public class Habilitada1Dose implements StatusVacina{
    private String tipo;

    public Habilitada1Dose() {
        this.tipo = "HABILITADA PARA 1 DOSE";
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habilitada1Dose that = (Habilitada1Dose) o;
        return tipo.equals(that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}
