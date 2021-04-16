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

    public String cadastrarVacina() {
        String saida = "";

        this.vacinas.add(new Vacina());
        saida = "CADASTRO DE VACINA REALIDADO COM SUCESSO";

        return saida;
    }

    public int exibirQtdVacina() {
        return this.vacinas.size();
    }

    public String deletarVacina() {
        String saida = "";
        Vacina vacina = this.vacinas.get(this.vacinas.size()-1);

        this.vacinas.remove(vacina);
        saida = "VACINA DELETADA COM SUCESSO";

        return saida;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }
}
