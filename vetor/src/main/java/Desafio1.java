public class Desafio1 {

    public static void main(String[] args) {
        int[] vetor = new int[2];

        int soma = 0;

        for (int v : vetor) {
            soma += vetor.length;
        }
        System.out.println(soma);
    }
}
