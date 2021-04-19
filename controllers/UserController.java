package controllers;

import models.Usuario;
import util.Util;

import java.util.HashMap;
import java.util.Map;

public class UserController {

    private Map<String, Usuario> pacientes;

    public UserController() {

        this.pacientes = new HashMap<>();
    }

    public String cadastraPacientes(String nome, String cpf, String endereco, String cartaoSUS, String email, String telefone, String profissao, String comorbidades, int idade) {
        String saida = "";
        Util.validadorString(nome);
        Util.validadorString(cpf);
        Util.validadorString(endereco);
        Util.validadorString(cartaoSUS);
        Util.validadorString(email);
        Util.validadorString(telefone);;
        Util.validadorString(profissao);
        Util.validadorString(comorbidades);
        Util.validadorValor(idade);

        this.pacientes.put(cpf, new Usuario(nome, cpf, endereco, cartaoSUS, email, telefone, profissao, comorbidades, idade));
        saida = "CADASTRO REALIDADO COM SUCESSO";

        return saida;
    }

    public String listarPacientes() {
        String saida = "";
        for (int i = 0; i < this.pacientes.size() ; i++) {
            saida = pacientes.get(i).toString() + System.lineSeparator();
        }

        saida += "CADASTRO REALIDADO COM SUCESSO";

        return saida;
    }
    public void atualizaStatusVacinacao(String CPF) {
        Util.validadorString(CPF);
        if(this.pacientes.containsKey(CPF)) {
            this.pacientes.get(CPF).atualizaStatusVacinacao();
        } else {
            throw new IllegalArgumentException("NAO EXISTE PACIENTE CADASTRADO COM ESSE CPF");
        }
    }

    public Map<String, Usuario> getPacientes() {
        return pacientes;
    }
}