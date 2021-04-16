package models;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Vacina {
    private static final AtomicInteger count = new AtomicInteger(0);
    private String nomeVacina;
    private LocalDate dataAplicada;
    private final int vacinaId;

    public Vacina() {
        this.nomeVacina = "COVID19";
        this.dataAplicada = LocalDate.now();
        // gera um id automaticamente
        this.vacinaId = count.incrementAndGet();
    }

    public LocalDate getDataAplicada() {
        return dataAplicada;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    @Override
    public String toString() {
        return String.format("Vacina para %s aplicada as %s", getNomeVacina(), getDataAplicada());
    }
}
