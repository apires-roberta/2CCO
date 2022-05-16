import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestFilme {

    public static void gravaArquivoCsv(ListaObj<Filme> lista, String nomeArq) {
        FileWriter arq = null; // objeto que representa o arquivo que será usado para escrita
        Formatter saida = null; // objeto que será usado para escrever no arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";   // acrescenta a extensão do arquivo .csv

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq);
            // no comando anterior, se quiser abrir o arquivo para acrescentar no final
            // tem que ser arq = new FileWriter(nomeArq, true);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo!");
            System.exit(1);
        }

        // Bloco try-catch para gravar no arquivo
        try {
            // Percorro a lista de cachorros
            for (int i = 0; i < lista.getTamanho(); i++) {
                // Obtenho um objeto da lista por vez (índice i)
                Filme filme = lista.getElemento(i);
                // Gravo um registro com as informações do objeto dog
                // Delimito cada campo com ; pois é um arquivo CSV
                // Importante aqui: não preencher com espaços em branco
                saida.format("%d;%s;%.2f;%s;%d\n", filme.getIdFilme(), filme.getNome(), filme.getNota(), filme.getGenero(), filme.getIdade());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar arquivo");
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leArquivoCsv(String nomeArq) {
        FileReader arq = null; // obj que representa o arquivo que será aberto para leitura
        Scanner entrada = null; // obj que será usado para ler do arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            // defino que o delimitador de campo na leitura será o ; ou o \n (final do registro)
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try-catch para ler o arquivo
        try {
            // Exibe uma linha com os títulos das colunas
            System.out.printf("%8s %-15s %5s %-15s %2s\n", "IDFILME", "NOME", "NOTA", "GÊNERO", "IDADE");
            while (entrada.hasNext()) {     // enquanto não chega ao final do arquivo
                // Leio o valor de cada campo, como quando leio do teclado usando Scanner
                int idfilme = entrada.nextInt();
                String nome = entrada.next();// aqui o next lê a String delimitada por ; então lê mesmo qdo tem nomes separados por branco
                Double nota = entrada.nextDouble();
                String genero = entrada.next();
                int idade = entrada.nextInt();
                // Exibe os dados em formato de colunas
                System.out.printf("%08d %-15s %5.2f %-15s %2d\n", idfilme, nome, nota, genero, idade);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        ListaObj<Filme> lista = new ListaObj<>(5);

        boolean fim = false;

        int idFilme;
        String nome;
        Double nota;
        String genero;
        int idade;

        int resposta;
        int indice;

        String listaFilme;
        String nomeArq;

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);

        while (!fim) {
            System.out.println("1. Adicionar um filme\n" +
                    "2. Exibir a lista\n" +
                    "3. Gravar a lista em arquivo CSV\n" +
                    "4. Ler e exibir um arquivo CSV\n" +
                    "5. Gravar em outro arquivo CSV apenas filmes que estão na lista, mas de um determinado gênero\n" +
                    "6. Sair");
            resposta = sc1.nextInt();

            switch (resposta) {
                case 1:
                    System.out.println("Digite o ID do filme: ");
                    idFilme = sc1.nextInt();
                    System.out.println("Digite o NOME do filme: ");
                    nome = sc2.nextLine();
                    System.out.println("Digite a NOTA do filme: ");
                    nota = sc3.nextDouble();
                    System.out.println("Digite o GÊNERO do filme: ");
                    genero = sc2.nextLine();
                    System.out.println("Digite a FAIXA ETÁRIA do filme ");
                    idade = sc1.nextInt();

                    Filme filme = new Filme(idFilme, nome, nota, genero, idade);
                    lista.adiciona(filme);
                    break;

                case 2:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia");
                    } else {
                        lista.exibe();
                    }
                    break;

                case 3:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há nada a gravar");
                    } else {
                        gravaArquivoCsv(lista, "filme");
                        System.out.println("Arquivo gravado!");
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome do arquivo a ser lido: ");
                    listaFilme = sc2.nextLine();
                    leArquivoCsv(listaFilme);
                    break;

                case 5:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há nada a gravar");
                    } else {
                        System.out.println("Digite o nome do arquivo a ser gravado: ");
                        nomeArq = sc2.nextLine();

                        System.out.println("Digite o gênero: ");
                        genero = sc2.nextLine();

                        for (int i = 0; i < lista.getTamanho(); i++) {
                            if (lista.getElemento(i).getGenero().equals(genero)) {
                                gravaArquivoCsv(lista, nomeArq);
                                break;
                            } else {
                                System.out.println("Não há filmes com esse gênero na lista!");
                            }
                        }
                        break;
                    }

                case 6:
                    System.out.println("Até logo!");
                    fim = true;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
