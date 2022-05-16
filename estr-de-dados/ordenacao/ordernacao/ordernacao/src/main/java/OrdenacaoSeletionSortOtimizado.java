import java.util.Scanner;

public class OrdenacaoSeletionSortOtimizado {

    public static void selectionSortOtimizado(int[] v){
        int i, j, indMenor, aux;
        for (i = 0; i < v.length-1; i++){
            indMenor = i;
            for (j = i + 1; j < v.length-1; j++){
                if(v[j] < v[indMenor]){
                    indMenor = j;
                }
            }
            aux = v[i];
            v[i] = v[j];
            v[j] = aux;
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int[] vetor = new int[5];

        for (int i = 0; i < vetor.length; i++){
            System.out.println("Informe o " + i + "° valor: ");
            vetor[i] = leitor.nextInt();
        }

        selectionSortOtimizado(vetor);

        for (int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }

    }
}
