package listaVetor;

import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int vetor[] = new int[10];

        for(int i = 0; i < vetor.length; i++){
            System.out.println("Informe o " + i + "° número: " );
            vetor[i] = leitor.nextInt();
        }

        double media = 0.0;
        int soma = 0;

        for (int i = 0; i < vetor.length; i++){
            soma += vetor[i];
            media = soma / vetor.length;
        }
        System.out.println(media);
    }
}
