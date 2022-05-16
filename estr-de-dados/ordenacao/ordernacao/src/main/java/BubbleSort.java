import java.util.Scanner;

public class BubbleSort {
    public static void blubbleSort(int[] v) {
        int i, j, aux;
        for (i = 0; i < v.length - 1; i++){
            for(j = 1; j < v.length-i; j++){
                if(v[j-1] > v[j]){
                    aux = v[j-1];
                    v[j-1] = v[j];
                    v[j] = aux;
                }
            }
        }
    }

    public static void exibeVetor(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print("vetor[" + i + "]=" + v[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[5];

        for (int i = 0; i < vetor.length; i++){
            System.out.println("Informe o "+i+" ° valor: ");
            vetor[i] = leitor.nextInt();
        }

        blubbleSort(vetor);
        exibeVetor(vetor);

    }
}
