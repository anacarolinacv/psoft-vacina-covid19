package helpers;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

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

    public static boolean validaProdissao(String profissao) {
        boolean saida = true;
        if(!(profissao.equals("MEDICO") || profissao.equals("ENFERMEIRO") || profissao.equals("PROFESSOR") || profissao.equals("FISIOTERAPEUTO"))) {
            saida = false;
        }
        return saida;
    }

    public static boolean validaComorbidade(String[] comorbidades) {
        String[] comparacoesComorbidades = {"diabetes", "obesidade", "hipertensão arterial", "tuberculose", "doença pulmonar", "obstrutiva crônica", "problemas cardíacos"};
        ArrayList arrayComorbidades = (ArrayList) Arrays.asList(comparacoesComorbidades);

        for (int i = 0; i < comorbidades.length; i++) {
            if (arrayComorbidades.contains(comorbidades[i])) return true;
        }

        return false;
    }

    public static boolean validaDataPSegundaDose(LocalDate data) {
        LocalDate dataAtual = LocalDate.now();
        boolean saida = false;
        if(dataAtual.getMonthValue() == data.getMonthValue()) {
            if(dataAtual.getDayOfMonth() - data.getDayOfMonth() >= 15) {
                saida = true;
            }
        } else {
            if(data.getMonthValue() == 2) {
                if(dataAtual.getDayOfMonth() + (28 - data.getDayOfMonth()) >= 15) {
                    saida = true;
                }
            } else if(data.getMonthValue() % 2 == 0) {
                if(dataAtual.getDayOfMonth() + (30 - data.getDayOfMonth()) >= 15) {
                    saida = true;
                }
            } else  {
                if(dataAtual.getDayOfMonth() + (31 - data.getDayOfMonth()) >= 15) {
                    saida = true;
                }
            }
        }
        return saida;
    }
}