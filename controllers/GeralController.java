package controllers;

import models.Usuario;
import models.status.*;
import util.Util;

import java.time.LocalDate;

public class GeralController {

    private UserController userController;
    private VacinacaoController vacinaController;

    public GeralController() {
        this.userController = new UserController();
        this.vacinaController = new VacinacaoController();
    }

    public String inicializarVacinacao(int idade, String comorbidades, String profissoes) {
        return this.vacinaController.iniciarVacinacao(idade, comorbidades, profissoes);
    }

    public void  cadastrarPaciente(String nome, String cpf, String endereco, String cartaoSUS, String email, String telefone, String profissao, String comorbidades, int idade) {
        boolean result1 = Util.validaProfissao(profissao, this.vacinaController.getProfissoesPadrao());
        boolean result2 = Util.validaComorbidade(comorbidades, this.vacinaController.getComorbidadesPadrao());
        boolean result3 = Util.validaIdade(idade, this.vacinaController.getIdadePadrao());
        this.userController.cadastraPacientes(nome, cpf, endereco, cartaoSUS, email, telefone, profissao, comorbidades, idade);

        boolean resultFINAL = (result1 || result2 || result2);
        this.userController.getPacientes().get(cpf).aplicaSituacaoVacinaInicial(resultFINAL);
    }

    public void editarPaciente(String cpf, String campo) {
        Usuario user = this.userController.getPacientes().get(cpf);
        if(this.userController.getPacientes().containsKey(cpf)) {
            switch (campo) {
                case "NOME":
                    user.setNome(campo);
                    break;
                case "TELEFONE":
                    user.setTelefone(campo);
                    break;
                case "CARTA OSUS":
                    user.setCartaoSUS(campo);
                    break;
                case "EMAIL":
                    user.setEmail(campo);
                    break;
                case "ENDERECO":
                    user.setEndereco(campo);
                    break;
                case "PROFISSAO":
                    user.setProfissao(campo);
                    break;
                case "IDADE":
                    user.setIdade(Integer.parseInt(campo));
                    break;
                case "COMORBIDADES":
                    user.setComorbidades(campo);
                    break;
                default:
                    throw new IllegalArgumentException("NAO EXISTE ESSE CAMPO NO CADASTRO DE PACIENTE");

            }
        }
    }
    public void cadastrarVacinas(int qtd) {
        this.vacinaController.cadastrarVacinas(qtd);
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
