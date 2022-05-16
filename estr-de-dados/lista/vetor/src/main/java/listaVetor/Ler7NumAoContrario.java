package listaVetor;

import java.util.Scanner;

public class Ler7NumAoContrario {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int[] vetor = new int[7];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe o " + i + "° valor: ");
            vetor[i] = leitor.nextInt();
        }
        for (int j = vetor.length-1; j >= 0; j--) {
            System.out.println(vetor[j]);
        }
    }
}
