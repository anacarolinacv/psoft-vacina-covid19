package models;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Vacina {
    private static final AtomicInteger count = new AtomicInteger(0);
    private String nomeVacina;
    private final int vacinaId;

    public Vacina() {
        this.nomeVacina = "COVID19";
        // gera um id automaticamente
        this.vacinaId = count.incrementAndGet();
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public int getVacinaId() {
        return vacinaId;
    }

    @Override
    public String toString() {
        return String.format("Vacina %s - ID (%s)", getNomeVacina(), getVacinaId());
    }
}
