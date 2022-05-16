public class OrdenacaoSelectionSort {

    public static void exibeVetor(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print("vetor[" + i + "]=" + v[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] vetor = {3, 5, 6, 2, 7, 1};

        int aux = 0;

        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i] > vetor[j]) {
                    aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }
        exibeVetor(vetor);
    }
}
