package controllers;

import helpers.Util;
import models.Usuario;

public class GeralController {

    private UserController userController;
    private VacinaController vacinaController;

    public GeralController() {
        this.userController = new UserController();
        this.vacinaController = new VacinaController();
    }
    // comorbidade tem que ser uma string assim: "manana, kakakaka, akakaka, akakak"
    public void  cadastrarPaciente(String nome, String cpf, String endereco, String cartaoSUS, String email, String telefone, String profissao, String comorbidades, int idade) {
        this.userController.cadastraPacientes(nome, cpf, endereco, cartaoSUS, email, telefone, profissao, comorbidades, idade);
    }
    public void cadastrarVacina() {
        this.vacinaController.cadastrarVacina();
    }

    public String listarPacientes() {
        return this.userController.listarPacientes();
    }

    public int listarQTDVacinas() {
        return this.vacinaController.exibirQtdVacina();
    }

    public String deletarVacina() {
        return this.vacinaController.deletarVacina();
    }

    public void atualizaStatusVacinacao(String CPF) {
        Util.validadorString(CPF);
        Usuario usuario = this.userController.getPacientes().get(CPF);

        if(this.vacinaController.exibirQtdVacina() > 0) {
            this.userController.atualizaStatusVacinacao(CPF);
        } else {
            throw new NullPointerException("NAO EXISTE VACINA CADASTRADA");
        }

        if(usuario.getStatusVacinacao().getTipo().equals("1 DOSE APLICADA") || usuario.getStatusVacinacao().getTipo().equals("2 DOSE APLICADA")) {
            deletarVacina();
            if(usuario.getStatusVacinacao().getTipo().equals("2 DOSE APLICADA")) {
                this.userController.atualizaStatusVacinacao(CPF);
            }
        }
    }
}
