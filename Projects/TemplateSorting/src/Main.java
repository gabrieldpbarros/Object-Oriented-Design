import comparators.LastCharacter;
import comparators.StringSize;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s1 = "Teste";
        String s2 = "Testando";
        String s3 = "Bom dia";
        String s4 = "Boa noite";
        String s5 = "Bem vindo";
        String s6 = "Insira mensagem criativa";
        String[] l1 = {s1, s2, s3, s4, s5, s6};

        Arrays.sort(l1, new LastCharacter());
        System.out.println("Último caractere: " + Arrays.toString(l1));

        Arrays.sort(l1, new StringSize());
        System.out.println("Tamanho da string: " + Arrays.toString(l1));
    }
}
