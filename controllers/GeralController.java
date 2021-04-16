package controllers;

public class GeralController {

    private UserController userController;
    private VacinaController vacinaController;

    public GeralController() {
        this.userController = new UserController();
        this.vacinaController = new VacinaController();
    }

    public String cadastrarPaciente(String nome, String cpf, String endereco, String cartaoSUS, String email, String telefone, String profissao, String comorbidades, int idade) {
        return this.userController.cadastraPacientes(nome, cpf, endereco, cartaoSUS, email, telefone, profissao, comorbidades, idade);
    }
    public String cadastrarVacina() {
        return this.vacinaController.cadastrarVacina();
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
}
