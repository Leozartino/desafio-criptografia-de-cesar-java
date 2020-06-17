package challenge;

public class CriptografiaCesariana implements Criptografia {
    static int salto = 3;

    @Override
    public String criptografar(String texto) {

        validaTexto(texto);

        char[] textoParaChar = texto.toLowerCase().toCharArray();
        int tamanhoTexto = textoParaChar.length;
        char[] textoCharCifrado = new char[tamanhoTexto];

        for (int index = 0; index < tamanhoTexto; index++) {
            if (textoParaChar[index] >= 97 && textoParaChar[index] <= 119) {
                textoCharCifrado[index] = (char) (textoParaChar[index] + salto);
            } else if (textoParaChar[index] > 119 && textoParaChar[index] <= 122) {
                textoCharCifrado[index] = (char) (textoParaChar[index] - 23);
            } else {
                textoCharCifrado[index] = textoParaChar[index];
            }

        }

        String textoCifrado = new String(textoCharCifrado);
        return textoCifrado;

    }

    @Override
    public String descriptografar(String texto) {

        validaTexto(texto);

        char[] textoParaChar = texto.toLowerCase().toCharArray();
        int tamanhoTexto = textoParaChar.length;
        char[] textoCharCifrado = new char[tamanhoTexto];

        for (int i = 0; i < tamanhoTexto; i++) {
            if (textoParaChar[i] >= 100 && textoParaChar[i] <= 122) {
                textoCharCifrado[i] = (char) (textoParaChar[i] - salto);
            } else if (textoParaChar[i] >= 97 && textoParaChar[i] < 100) {
                textoCharCifrado[i] = (char) (textoParaChar[i] + 23);
            } else {
                textoCharCifrado[i] = textoParaChar[i];
            }
        }

        String textoCifrado = new String(textoCharCifrado);
        return textoCifrado;

    }

    private void validaTexto(String texto) {
        if (texto.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (texto.equals(null)) {
            throw new NullPointerException();
        }
    }
}
