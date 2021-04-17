package helpers;


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
}