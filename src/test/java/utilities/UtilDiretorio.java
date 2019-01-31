package utilities;

public class UtilDiretorio {

    public static String alteraDiretorio (String diretorio) {

        String texto = "";
        String aux;

        for (int i=0; i<diretorio.length(); i++) {
            char c = diretorio.charAt(i);
            aux = Character.toString(c);

            if (aux.equals("\\")) {
                texto = texto + "/";
            } else {
                texto = texto + aux;
            }

        }

        return texto;
    }

    public static String retornaDiretorioProjeto() {
        return System.getProperty("user.dir");
    }
}
