package helpers;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    public static void validadorString(String parametro) {

        if(parametro == null) {
        throw new NullPointerException("Parametro incorreto: NULO");
        } else if (parametro.trim().equals("")) {
        throw new IllegalArgumentException("Parametro incorreto: VAZIO");
        }
    }

    public static void validadorValor(int parametro) {

        if(parametro < 0) {
            throw new IllegalArgumentException("Parametro incorreto: ZERADO");
        }
    }

    public static boolean validaProfissao(String profissao, String profissaoPadrao) {
        ArrayList arrayComorbidades = (ArrayList) Arrays.asList(profissaoPadrao.replaceAll(" ", "").split(","));

        return arrayComorbidades.contains(profissao);

    }

    public static boolean validaComorbidade(String comorbidades, String comorbidadesPadrao) {
        List<String> arrayComorbidadesPaciente = Arrays.asList(comorbidades.replaceAll(" ","").split(","));
        List<String> arrayComorbidadesPadrao = Arrays.asList(comorbidadesPadrao.replaceAll(" ","").split(","));
        boolean saida = false;

        for (int i = 0; i < arrayComorbidadesPadrao.size() ; i++) {

            if(arrayComorbidadesPaciente.contains(arrayComorbidadesPadrao.get(i))) {
                saida = true;
                break;
            }
        }
        return saida;
    }

    public static boolean validaIdade(int idade, int idadePadrao) {

        return idade >= idadePadrao;

    }

    public static boolean validaDataPSegundaDose(LocalDate data) {
        LocalDate dataAtual = LocalDate.now();
        boolean saida = false;
        if(dataAtual.getMonthValue() == data.getMonthValue()) {
            if(dataAtual.getDayOfMonth() - data.getDayOfMonth() >= 20) {
                saida = true;
            }
        } else {
            if(data.getMonthValue() == 2) {
                if(dataAtual.getDayOfMonth() + (28 - data.getDayOfMonth()) >= 20) {
                    saida = true;
                }
            } else if(data.getMonthValue() % 2 == 0) {
                if(dataAtual.getDayOfMonth() + (30 - data.getDayOfMonth()) >= 20) {
                    saida = true;
                }
            } else  {
                if(dataAtual.getDayOfMonth() + (31 - data.getDayOfMonth()) >= 20) {
                    saida = true;
                }
            }
        }
        return saida;
    }
}