package listaVetor;

import java.util.Scanner;

public class BuscaNomes {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitor2 = new Scanner(System.in);

        String vetor[] = new String[3];

        String nome = "";

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe o " + i + "° nome: ");
            vetor[i] = leitor.nextLine();
        }

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Busque um nome: ");
            nome = leitor2.nextLine();

            if (vetor[i].equals(nome)) {
                System.out.println("Nome encontrado");
                break;
            }else{
                System.out.println("Informe o nome correto.");
            }

        }
    }
}


