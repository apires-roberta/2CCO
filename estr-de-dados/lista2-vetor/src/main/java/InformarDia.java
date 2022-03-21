import java.util.Scanner;

public class InformarDia {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um dia do mês (Ex: 1; 15; 31; etc): ");
        int dia = leitor.nextInt();

        System.out.println("Digite um mês (Ex: 1; 2; 10; etc): ");
        int[] vetorMes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int mes = leitor.nextInt();

        int soma = 0;

        soma = ((vetorMes[mes-1]-1) * 31) + dia;
        //       ((vetorMes[3-1]-1) * 31) + 5


        System.out.println(soma);
    }
}
