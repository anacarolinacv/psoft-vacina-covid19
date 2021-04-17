package main;

import controllers.GeralController;

import java.util.Scanner;

public class ControllCOVID {

    private static String exibirControlCovid() {
        String menu = "\nCadastrar Paciente (C)" + System.lineSeparator() +
                "Cadastrar Vacina (O)" + System.lineSeparator() +
                "Listar Pacientes (V)" + System.lineSeparator() +
                "Exibir Quantidade de vacinas (I)" + System.lineSeparator() +
                "Atualizar o status do paciente (D)" + System.lineSeparator() +
                "Sair (S)" + System.lineSeparator() + System.lineSeparator() +
                "Opção> ";

        return menu;
    }

    public static void main(String[] args) {
        GeralController covidontroler = new GeralController();
        String entrada;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(exibirControlCovid());
            entrada = sc.nextLine().toUpperCase();
            switch (entrada) {
                case "C":
                    cadastrarPaciente(covidontroler);
                    break;
                case "O":
                    cadastrarVacina(covidontroler);
                    break;
                case "V":
                    listarPacientes(covidontroler);
                    break;
                case "I":
                    exibirQtdVacinas(covidontroler);
                    break;
                case "D":
                    atualizarPaciente(covidontroler);
                    break;
                case "S":
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }
        } while (!entrada.equals("S"));

    }
    // String nome, String cpf, String endereco, String cartaoSUS, String email, String telefone, String profissao, String comorbidades, int idade
    private static void cadastrarPaciente(GeralController controller) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Cartão SUS: ");
        String cartaoSUS = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Profissão: ");
        String profissao = sc.nextLine();

        System.out.print("Comorbidades: ");
        System.out.print("Formato: x, y, z..");
        String comorbidades = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        controller.cadastrarPaciente(nome, cpf, endereco, cartaoSUS, email, telefone, profissao, comorbidades, idade);
        System.out.println("CADASTRO REALIZADO!");
    }
    private static void cadastrarVacina(GeralController controller) {
        controller.cadastrarVacina();
        System.out.println("CADASTRO REALIZADO!");
    }
    private static void listarPacientes(GeralController controller) {
        System.out.println();
        System.out.println(controller.listarPacientes());
    }
    private static void exibirQtdVacinas(GeralController controller) {
        System.out.println();
        System.out.println(controller.listarQTDVacinas());
    }

    private static void atualizarPaciente(GeralController controller) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        controller.atualizaStatusVacinacao(cpf);
        System.out.println("PACIENTE ATUALIZADO COM SUCESSO!");
    }
}
