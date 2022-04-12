import java.util.List;
import java.util.Scanner;

public class TesteListaAluno {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitor2 = new Scanner(System.in);
        Scanner leitor3 = new Scanner(System.in);


        boolean fim = false;

        int ra = 0;
        String nome;
        double nota = 0.0;

        ListaObj<Aluno> lista = new ListaObj(10);

        int resposta;

        while (!fim) {
            System.out.println("Escolha uma das opções: \n" +
                    "1. Adicionar um aluno\n" +
                    "2. Exibir a lista\n" +
                    "3. Exibir um aluno da lista\n" +
                    "4. Limpar a lista\n" +
                    "5. Buscar um aluno pelo RA\n" +
                    "6. Fim \n");

            resposta = leitor.nextInt();

            switch (resposta) {
                case 1:
                    System.out.println("Informe o RA: ");
                    ra = leitor2.nextInt();

                    System.out.println("Informe a Nota: ");
                    nota = leitor2.nextDouble();

                    System.out.println("Informe o Nome do Aluno: ");
                    nome = leitor3.nextLine();

                    Aluno aluno1 = new Aluno(ra, nome, nota);

                    lista.adiciona(aluno1);
                    break;

                case 2:
                    lista.exibe();
                    break;

                case 3:
                    System.out.println("Informe o indice da lista para exibir o aluno: ");

                    int indice = leitor2.nextInt();

                    lista.getElemento(indice);
                    break;

                case 4:
                    lista.limpa();
                    break;

                case 5:
                    System.out.println("Informe o RA do aluno: ");

                    int resp = leitor2.nextInt();

                    for (int i = 0; i < lista.getTamanho(); i++) {
                        if (resp == lista.getElemento(i).getRa()) {
                            lista.getElemento(i).getRa();
                            lista.getElemento(i).getNome();
                            lista.getElemento(i).getNota();
                        } else {
                            System.out.println("Aluno não encontrado");
                        }
                    }
                    break;

                case 6:
                    fim = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
