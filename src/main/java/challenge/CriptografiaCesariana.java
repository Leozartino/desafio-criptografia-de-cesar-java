package challenge;

public class CriptografiaCesariana implements Criptografia {
    static int salto = 3;
    static int valorIntervaloA;
    static int valorIntervaloB;
    static int valorIntervaloC;
    static int valorIntervaloD;
    static int valorFormula;

    @Override
    public String criptografar(String texto) {

        return algoritmoCesar(texto, salto);

    }

    @Override
    public String descriptografar(String texto) {

        return algoritmoCesar(texto, -salto);

    }

    private String algoritmoCesar(String texto, int salto) {
        validaTexto(texto);

        char[] textoParaChar = texto.toLowerCase().toCharArray();
        int tamanhoTexto = textoParaChar.length;
        char[] textoCharMensagem = new char[tamanhoTexto];

        if (salto < 0) {
            valorIntervaloA = 100;
            valorIntervaloB = 122;
            valorIntervaloC = 97;
            valorIntervaloD = 100;
            valorFormula = 23;
        } else {
            valorIntervaloA = 97;
            valorIntervaloB = 119;
            valorIntervaloC = 119;
            valorIntervaloD = 122;
            valorFormula = -23;
        }

        for (int i = 0; i < tamanhoTexto; i++) {
            if (textoParaChar[i] >= valorIntervaloA && textoParaChar[i] <= valorIntervaloB) {
                textoCharMensagem[i] = (char) (textoParaChar[i] + salto);
            } else if (textoParaChar[i] >= valorIntervaloC && textoParaChar[i] < valorIntervaloD) {
                textoCharMensagem[i] = (char) (textoParaChar[i] + valorFormula);
            } else {
                textoCharMensagem[i] = textoParaChar[i];
            }
        }

        String textoResultante = new String(textoCharMensagem);
        return textoResultante;
    }

    private void validaTexto(String texto) {
        if (texto.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (texto.equals(null)) {
            throw new NullPointerException();
        }
    }
}
