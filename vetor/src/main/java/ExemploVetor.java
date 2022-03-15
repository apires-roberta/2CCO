import java.util.Scanner;

public class ExemploVetor {

    public static void exibeVetor(int[] v){
        for (int i = 0; i < v.length; i++){
            System.out.print("vetor["+i+"]=" + v[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner leitor= new Scanner(System.in);

        int [] vetor = new int[5];

        int[] vet2 = {100,200,300,400,500,600,700};

        String[] vet3 = new String[5];

        for (int i = 0; i < vetor.length; i++){
            vetor[i] = i * 10;
        }

        exibeVetor(vetor);
        exibeVetor(vet2);

        for(int i =0; i < vetor.length; i++){
            System.out.println("Digite o valor pra vetor[" +i+ "]: ");
            vetor[i] = leitor.nextInt();
        }

        exibeVetor(vetor);

        for(int i =0; i < vet3.length; i++){
            System.out.println("Digite o valor pra vetor[" +i+ "]: ");
            vet3[i] = leitor.nextLine();
        }

        for(String nome : vet3){
            System.out.print(nome + "\t");
        }
        System.out.println();

    }
}
