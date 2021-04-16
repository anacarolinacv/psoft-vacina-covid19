package helpers;


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
}