package models;

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
    private String situacaoAtual;
    private int idade;
    private String[] vacinasTomadas;


    public Usuario (String nome, String cpf, String endereco, String cartaoSUS, String email, String telefone, String profissao, String comorbidades, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = cartaoSUS;
        this.email = email;
        this.telefone = telefone;
        this.profissao = profissao;
        this.comorbidades = comorbidades.split(", ");
        this.idade = idade;
        this.situacaoAtual = aplicaSituacaoVacinaInicial();
        this.vacinasTomadas = new String[2];
    }

    public String aplicaSituacaoVacinaInicial() {
        if(this.idade >= 60) {
            // HABILITADA
        } else {
            // NAO HABILITADA
        }
        return "";
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