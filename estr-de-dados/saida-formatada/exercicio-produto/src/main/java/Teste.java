import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Teste {


        public static void gravaArquivoCsv(ListaObj<Produto> lista, String nomeArq) {
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
                    Produto produto = lista.getElemento(i);
                    saida.format("%d;%s;%.2f;%s;%.3f\n", produto.getCodProduto(), produto.getNome(), produto.getPreco(), produto.getAvaliacao(), produto.calcularFaturamento());
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
                System.out.printf("%-6s %-14s %6s %7s %14s\n", "CODIGO", "NOME", "PREÇO", "NOTA", "FATURAMENTO");
                while (entrada.hasNext()) {
                    int codProduto = entrada.nextInt();
                    String nome = entrada.next();
                    double preco = entrada.nextDouble();
                    String avaliacao = entrada.next();
                    double faturamento = entrada.nextDouble();
                    System.out.printf("%06d %-14s %6.2f %7s %14.3f\n", codProduto, nome, preco, avaliacao, faturamento);
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
        ListaObj<Produto> listaProd = new ListaObj(5);

        Produto prod1 = new Produto(123, "Notebook", 10.50, "***");
        Produto prod2 = new Produto(456, "Mouse", 2.50, "*");
        Produto prod3 = new Produto(789, "Teclado", 10.40, "***");
        Produto prod4 = new Produto(444, "TV", 150.56, "*****");
        Produto prod5 = new Produto(555, "Monitor", 100.50, "****");

        prod1.compra(5);
        prod2.compra(5);
        prod3.compra(5);
        prod4.compra(5);
        prod5.compra(5);

//        prod1.toString();
//        System.out.printf("%06d %-14s %6.2f %7s %14.3f\n", prod1.getCodProduto(),
//                prod1.getNome(),
//                prod1.getPreco(),
//                prod1.getAvaliacao(),
//                prod1.calcularFaturamento());
//
//        System.out.printf("%06d %-14s %6.2f %7s %14.3f\n", prod2.getCodProduto(),
//                prod2.getNome(),
//                prod2.getPreco(),
//                prod2.getAvaliacao(),
//                prod2.calcularFaturamento());
//
//        System.out.printf("%06d %-14s %6.2f %7s %14.3f\n", prod3.getCodProduto(),
//                prod3.getNome(),
//                prod3.getPreco(),
//                prod3.getAvaliacao(),
//                prod3.calcularFaturamento());
//
//        System.out.printf("%06d %-14s %6.2f %7s %14.3f\n", prod4.getCodProduto(),
//                prod4.getNome(),
//                prod4.getPreco(),
//                prod4.getAvaliacao(),
//                prod4.calcularFaturamento());
//
//        System.out.printf("%06d %-14s %6.2f %7s %14.3f\n", prod5.getCodProduto(),
//                prod5.getNome(),
//                prod5.getPreco(),
//                prod5.getAvaliacao(),
//                prod5.calcularFaturamento());

        listaProd.adiciona(prod1);
        listaProd.adiciona(prod2);
        listaProd.adiciona(prod3);
        listaProd.adiciona(prod4);
        listaProd.adiciona(prod5);

        listaProd.exibe();
        gravaArquivoCsv(listaProd, "produto");
        lerArquivo("produto");

    }
}
