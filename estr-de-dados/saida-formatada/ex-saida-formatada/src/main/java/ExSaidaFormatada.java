public class ExSaidaFormatada {
    public static void main(String[] args) {
        String nome1 = "Maria Aparecida Sousa";
        String nome2 = "João";

        int ra1 = 50000;
        int ra2 = 50001;

        double nota1 = 8.5;
        double nota2 = 7.0;

        System.out.printf("--------------------------------------\n");
        System.out.printf("%-7s %-14s %6s\n", "RA", "NOME", "NOTA");

        System.out.printf("%07d %-14.7S %6.2f\n", ra1, nome1, nota1);
        System.out.printf("%07d %-14S %6.2f\n", ra2, nome2, nota2);




    }
}
