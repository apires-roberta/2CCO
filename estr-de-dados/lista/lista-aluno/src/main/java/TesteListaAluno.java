import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TesteListaAluno {

    public static void gravaArquivoCsv(ListaObj<Aluno> lista, String nomeArq) {
        FileWriter arq = null; // obejto que representa o arquivo que será usado
        Formatter saida = null; // objeto que será usado para escrever no arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        //Bloco try-catch abrir o arquivo
        try {
            arq = new FileWriter(nomeArq, true);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo!");
            System.exit(1);
        }
        // Bloco try-catch para gravar no arquivo
        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Aluno aluno = lista.getElemento(i);
                saida.format("%d;%s;%.2f\n", aluno.getRa(), aluno.getNome(), aluno.getNota());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Errao ao gravar arquivo!");
            deuRuim = true;
        } finally {
            saida.close();

            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Errp ao fechar o arquivo!");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void lerArquivo(String nomeArq) {
        FileReader arq = null; // obj que representa o arquivo que será aberto para escrever o arquivo
        Scanner entrada = null; // onj que será usado para ler o arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        //Bloco try-catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        //Bloco try-catch para ler o arquivo
        try {
            System.out.printf("%-10s %-30s %5s \n", "CODIGO", "NOME", "NOTA");
            while (entrada.hasNext()) {
                int ra = entrada.nextInt();
                String nome = entrada.next();
                double nota = entrada.nextDouble();
                System.out.printf("%-10d %-30s %5.2f\n", ra, nome, nota);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas!");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo!");
        } finally {
            entrada.close();

            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Errp ao fechar o arquivo!");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

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
                    "6. Gravar a lista num arquivo csv\n" +
                    "7. Ler e exibir o arquivo csv\n" +
                    "8. Fim\n");

            resposta = leitor.nextInt();

            switch (resposta) {
                case 1:
                    System.out.println("Informe o RA: ");
                    ra = leitor2.nextInt();

                    System.out.println("Informe o Nome do Aluno: ");
                    nome = leitor3.nextLine();

                    System.out.println("Informe a Nota: ");
                    nota = leitor2.nextDouble();

                    Aluno aluno1 = new Aluno(ra, nome, nota);

                    lista.adiciona(aluno1);
                    break;

                case 2:
                    lista.exibe();
                    break;

                case 3:
                    System.out.println("Informe o indice da lista para exibir o aluno: ");

                    int indice = leitor2.nextInt();

                    System.out.println(lista.getElemento(indice));
                    break;

                case 4:
                    lista.limpa();
                    break;

                case 5:
                    System.out.println("Informe o RA do aluno: ");

                    int resp = leitor2.nextInt();

                    for (int i = 0; i < lista.getTamanho(); i++) {
                        if (resp == lista.getElemento(i).getRa()) {
                            System.out.println(lista.getElemento(i).toString());
                        } else {
                            System.out.println("Aluno não encontrado");
                        }
                    }
                    break;

                case 6:
                    gravaArquivoCsv(lista, "alunos");
                    break;

                case 7:
                    lerArquivo("alunos");
                    break;
                case 8:
                    fim = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
