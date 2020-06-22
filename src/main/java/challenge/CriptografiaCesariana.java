package challenge;

public class CriptografiaCesariana implements Criptografia {
    private final int SALTO = 3;
    private int valorIntervaloA;
    private int valorIntervaloB;
    private int valorIntervaloC;
    private int valorIntervaloD;
    private int valorFormula;

    @Override
    public String criptografar(String texto) {

        return algoritmoCesar(texto, SALTO);

    }

    @Override
    public String descriptografar(String texto) {

        return algoritmoCesar(texto, -SALTO);

    }

    private String algoritmoCesar(String texto, int SALTO) {
        validaTexto(texto);
        verificaSalto(SALTO);

        char[] textoParaChar = texto.toLowerCase().toCharArray();
        int tamanhoTexto = textoParaChar.length;
        char[] textoCharMensagem = new char[tamanhoTexto];

        for (int i = 0; i < tamanhoTexto; i++) {
            if (textoParaChar[i] >= valorIntervaloA && textoParaChar[i] <= valorIntervaloB) {
                textoCharMensagem[i] = (char) (textoParaChar[i] + SALTO);
            } else if (textoParaChar[i] >= valorIntervaloC && textoParaChar[i] < valorIntervaloD) {
                textoCharMensagem[i] = (char) (textoParaChar[i] + valorFormula);
            } else {
                textoCharMensagem[i] = textoParaChar[i];
            }
        }

        String textoResultante = new String(textoCharMensagem);
        return textoResultante;
    }

    private void verificaSalto(int salto) {
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
    }

    private void validaTexto(String texto) {
        if (texto == null) {
            throw new NullPointerException("O texto não pode ser nulo!");
        }
        if (texto.equals("")) {
            throw new IllegalArgumentException("O texto esta vazio!");
        }
    }
}