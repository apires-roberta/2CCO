import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteFilme {

    public static void gravaArquivoCSV(ListaObj<Filme> lista, String nomeArq){
        FileWriter arq = null; // Objeto que representa o arquivo que será usado para escrita/gravação
        Formatter saida = null; // Objeto que será usado para escrever o arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv"; // Acrescenta a extensão do arquivo .csv

        // Bloco trt-catch para abrir o arquivo
        try{
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo!");
            System.exit(1);
        }

        try{
            for (int i = 0; i < lista.getTamanho(); i++){
                Filme filme = lista.getElemento(i);
                saida.format("%d;%s;%.2f;%s;%d\n",
                        filme.getIdFilme(),
                        filme.getNome(),
                        filme.getNota(),
                        filme.getGenero(),
                        filme.getIdade());
            }
        }
        catch (FormatterClosedException erro){
            System.out.println("Erro ao gravar o arquivo!");
            deuRuim = true;
        }
        finally {
            saida.close();
            try{
                arq.close();
            }
            catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo!");
                deuRuim = true;
            }
            if (deuRuim){
                System.exit(1);
            }
        }
    }

    public static void lerArquivoCSV(String nomeArq){
        FileReader arq = null; // Objeto que representa o arquivo que será aberto para leitura
        Scanner entrada = null; // Objeto que será usado para ler o arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try{
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro){
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try-catch para ler o arquivo
        try{
            System.out.printf("%5s %-30s %5s %10s %2s\n", "ID", "NOME", "NOTA", "GENERO", "IDADE");
            while (entrada.hasNext()){
                int id = entrada.nextInt();
                String nome = entrada.next();
                double nota = entrada.nextDouble();
                String genero = entrada.next();
                int idade = entrada.nextInt();
                System.out.printf("%05d %-30s %5.2f %10s %2d\n",
                        id,
                        nome,
                        nota,
                        genero,
                        idade);
            }
        }
        catch (NoSuchElementException erro){
            System.out.printf("Arquivo com problema");
            deuRuim = true;
        }
        catch (IllegalStateException erro){
            System.out.println("Erro na leitura do arquivo");
        }
        finally {
            entrada.close();
            try{
                arq.close();
            }
            catch(IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if(deuRuim){
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {

        // Variáveis
        boolean continua = true;
        int idFilme;
        String nome;
        double nota;
        String genero;
        int idade;
        int opcao;
        String nomeArquivo;

        Scanner leitor = new Scanner(System.in);
        Scanner leitorN = new Scanner(System.in);

        ListaObj<Filme> listaFilme = new ListaObj<>(10);
        ListaObj<Filme> filmeGenero = new ListaObj<>(10);

        do{
            System.out.println("1. Adicionar um filme\n" +
                    "2. Exibir a lista\n" +
                    "3. Gravar a lista em arquivo CSV\n" +
                    "4. Ler e exibir um arquivo CSV\n" +
                    "5. Gravar em outro arquivo CSV apenas filmes que estão na lista, mas de um determinado gênero\n" +
                    "6. Sair\n");

            opcao = leitorN.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Digite o id do filme: ");
                    idFilme = leitorN.nextInt();
                    System.out.println("Digite o nome: ");
                    nome = leitor.next();
                    System.out.println("Digite a nota: ");
                    nota = leitorN.nextDouble();
                    System.out.println("Digite o genero: ");
                    genero = leitor.next();
                    System.out.println("Digite a idade mínima para assistir o filme: ");
                    idade = leitorN.nextInt();
                    listaFilme.adiciona(new Filme(idFilme, nome, nota, genero, idade));
                    break;
                case 2:
                    listaFilme.exibe();
                    break;
                case 3:
                    if (listaFilme.getTamanho() == 0){
                        System.out.println("Lista está vazia. Não há nada a gravar.");
                    }else{
                        gravaArquivoCSV(listaFilme, "Filmes");
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome do arquivo que deve ser lido: ");
                    nomeArquivo = leitor.next();
                    lerArquivoCSV(nomeArquivo);
                    break;
                case 5:
                    System.out.println("Digite o nome do arquivo que quer gravar: ");
                    nomeArquivo = leitor.next();
                    System.out.println("Digite o genero que deseja guardar nessa lista: ");
                    genero = leitor.next();

                    for (int i = 0; i < listaFilme.getTamanho(); i++){
                        if (listaFilme.getElemento(i).getGenero().equalsIgnoreCase(genero)){
                            filmeGenero.adiciona(listaFilme.getElemento(i));
                        }
                    }
                    if (listaFilme.getTamanho() == 0){
                        System.out.println("Lista está vazia. Não há nada a gravar.");
                    }else if(listaFilme.getTamanho() != 0 && filmeGenero.getTamanho() == 0){
                        System.out.println("Não há filmes deste gênero na lista");
                    }else{
                        gravaArquivoCSV(filmeGenero, nomeArquivo);
                    }
                    break;
                case 6:
                    continua = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(continua);

    }
}
