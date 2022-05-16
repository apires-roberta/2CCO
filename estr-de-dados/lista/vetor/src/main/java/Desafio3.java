import java.util.Scanner;

public class Desafio3 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String[] vetor = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};

        System.out.println(String.format("Digite um dia da semana: "));

        int indice = leitor.nextInt();

        while (indice < 1 || indice > 7) {
            System.out.println("Informe um valor válido de dia da semana.");
            System.out.println(String.format("Digite um dia da semana: "));
            indice = leitor.nextInt();
        }
        System.out.println("Dia da semana informado: " + vetor[indice] + "\n");
    }

}


