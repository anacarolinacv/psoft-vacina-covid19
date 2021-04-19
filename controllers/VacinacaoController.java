package controllers;

import models.Vacina;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class VacinacaoController {

    private List<Vacina> vacinas;
    private int idadePadrao;
    private String comorbidadesPadrao;
    private String profissoesPadrao;

    public VacinacaoController() {
        this.vacinas = new ArrayList<>();
    }

    public String iniciarVacinacao(int idade, String comorbidades, String profissoes) {
        Util.validadorString(comorbidades);
        Util.validadorString(profissoes);
        Util.validadorValor(idade);

        this.idadePadrao = idade;
        this.comorbidadesPadrao = comorbidades;
        this.profissoesPadrao = profissoes;

        return "VACINACAO INICIADA COM SUCESSO";
    }

    public String cadastrarVacinas(int qtd) {
        String saida = "";
        for (int i = 0; i < qtd; i++) {
            this.vacinas.add(new Vacina());
        }
        saida = "CADASTRO DE VACINAS REALIDADO COM SUCESSO";

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

    public int getIdadePadrao() {
        return idadePadrao;
    }

    public String getComorbidadesPadrao() {
        return comorbidadesPadrao;
    }

    public String getProfissoesPadrao() {
        return profissoesPadrao;
    }
}
