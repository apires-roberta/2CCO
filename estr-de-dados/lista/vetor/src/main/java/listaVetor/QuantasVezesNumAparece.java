package listaVetor;

import java.util.Arrays;
import java.util.Scanner;

public class QuantasVezesNumAparece {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int vetor[] = new int[3];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe o " + i + "° número: ");
            vetor[i] = leitor.nextInt();
        }

        System.out.println("Informe um número para verificar: ");
        int num = 0;
        num = leitor.nextInt();
        int cont = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == num) {
                cont++;
            }else{
                System.out.println("O número informado não apareceu nenhuma vez.");
            }
        }
        System.out.println("O número " + num + " apareceu " + cont);
    }
}
