import java.util.Scanner;



public class CarrosEconomicos {

    public static void exibeVetor(String[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print("vetor[" + i + "]=" + v[i] + "\t");
        }
        System.out.println();
    }

    public static void exibeVetor(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print("vetor[" + i + "]=" + v[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String[] vetor1 = new String[5];
        int[] vetor2 = new int[5];

        int maior = 0;

        int indice = 0;

        for (int i = 1; i < vetor1.length; i++) {
            System.out.println("Digite o " + i + "° carro");
            vetor1[i] = leitor.nextLine();
        }

        for (int i = 1; i < vetor2.length; i++) {
            System.out.println("Digite o redimento do " + i + "° carro");
            vetor2[i] = leitor.nextInt();
            if(vetor2[i] > maior){
                maior = vetor2[i];
                indice = i;

            }
        }

        System.out.println(vetor1[indice] + vetor2[indice]);

    }
}
