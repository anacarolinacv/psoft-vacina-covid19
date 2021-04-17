package models;

import helpers.Util;
import models.status.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Usuario {

    private String nome;
    private String cpf;
    private String endereco;
    private String cartaoSUS;
    private String email;
    private String telefone;
    private String profissao;
    private String[] comorbidades;
    private int idade;
    private LocalDate acompanhamentoVacinas;

    private StatusVacina statusVacinacao;


    public Usuario (String nome, String cpf, String endereco, String cartaoSUS, String email, String telefone, String profissao, String comorbidades, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cartaoSUS = cartaoSUS;
        this.email = email;
        this.telefone = telefone;
        this.profissao = profissao;
        this.comorbidades = comorbidades.split(", ");
        this.idade = idade;
        this.statusVacinacao = aplicaSituacaoVacinaInicial();

    }

    private StatusVacina aplicaSituacaoVacinaInicial() {
        StatusVacina status;

        if(this.idade >= 60 || Util.validaProdissao(this.profissao) || Util.validaComorbidade(this.comorbidades)) {
            status = new Habilitada1Dose();
        } else {
            status = new NaoHabilitada();
        }
        return status;
    }

    public void atualizaStatusVacinacao() {

        switch (this.statusVacinacao.getTipo()) {
            case "NAO HABILITADA":
                this.statusVacinacao = new Habilitada1Dose();
                break;
            case "HABILITADA PARA 1 DOSE":
                this.statusVacinacao = new Tomou1Dose();
                this.acompanhamentoVacinas = LocalDate.now();
                break;
            case "1 DOSE APLICADA":
                this.statusVacinacao = new Habilitada2Dose();
                break;
            case "HABILITADA PARA 2 DOSE":
                if(Util.validaDataPSegundaDose(this.acompanhamentoVacinas)) {
                    this.statusVacinacao = new Tomou2Dose();
                } else {
                    throw new IllegalArgumentException("SO PODE TOMAR A DOSE 2 DEPOIS DE 15 DIAS DA 1 DOSE");
                }
                break;
            case "2 DOSE APLICADA":
                this.statusVacinacao = new Imunizadah();
                break;

        }
    }

    public StatusVacina getStatusVacinacao() {
        return statusVacinacao;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCartaoSUS() {
        return cartaoSUS;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public String[] getComorbidades() {
        return comorbidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(cpf, usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return String.format("Usuario: %s - CPF: %S", getNome(), getCpf());
    }
}