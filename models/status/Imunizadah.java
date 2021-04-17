package models.status;

import java.util.Objects;

public class Imunizadah implements StatusVacina{
    private String tipo;

    public Imunizadah() {
        this.tipo = "IMUNIZADAH - Vacinacao concluida";
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imunizadah that = (Imunizadah) o;
        return tipo.equals(that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}
