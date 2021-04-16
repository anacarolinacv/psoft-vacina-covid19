package controllers;

import helpers.Util;
import models.Usuario;
import models.Vacina;

import java.util.ArrayList;
import java.util.List;

public class VacinaController {

    private List<Vacina> vacinas;

    public VacinaController() {
        this.vacinas = new ArrayList<>();
    }

    public String cadastrarVacina(String nome) {
        String saida = "";

        this.vacinas.add(new Vacina());
        saida = "CADASTRO DE VACINA REALIDADO COM SUCESSO";

        return saida;
    }

    public int exibirQtdVacina() {
        return this.vacinas.size();
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }
}
