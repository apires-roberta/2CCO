import java.util.Scanner;

public class TesteCarrinho {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        Boolean loop = true;

        while(loop) {
            System.out.println("Escolha uma opção: \n" +
                    "1. Adicionar livro \n" +
                    "2. Adicionar DVD \n" +
                    "3. Adicionar Servico \n" +
                    "4. Exibir itens do carrinho \n" +
                    "5. Exibir total devenda \n" +
                    "6. Fim \n");

            Scanner scanner = new Scanner(System.in); //int
            Scanner scanner2 = new Scanner(System.in); //double
            Scanner leitor = new Scanner(System.in); //string


            int opcao = scanner.nextInt();


            if (opcao == 1) {
                System.out.println("Informe os dados do livro: \n" +
                        "Código: \n" +
                        "Nome: \n" +
                        "Preço Custo: \n" +
                        "Autor: \n" +
                        "Isbn: \n");

                int codigo = scanner.nextInt();
                String nome = leitor.nextLine();
                double precoCusto = scanner2.nextDouble();
                String autor = leitor.nextLine();
                String isbn = leitor.nextLine();

                Livro livro = new Livro(codigo, nome, precoCusto, autor, isbn);
                carrinho.adicionarVenda(livro);

            } else if (opcao == 2) {
                System.out.println("Informe os dados do dvd: \n" +
                        "Código: \n" +
                        "Nome: \n" +
                        "Preço Custo: \n" +
                        "Gravadora: \n");

                int codigo = scanner.nextInt();
                String nome = leitor.nextLine();
                double precoCusto = scanner2.nextDouble();
                String gravadora = leitor.nextLine();

                Dvd dvd = new Dvd(codigo, nome, precoCusto, gravadora);
                carrinho.adicionarVenda(dvd);


            } else if (opcao == 3) {
                System.out.println("Informe os dados do serviço: \n" +
                        "Descricao: \n" +
                        "Código: \n" +
                        "QtdHoras: \n" +
                        "ValorHoras: \n");

                String descricao = leitor.nextLine();
                int codigo = scanner.nextInt();
                int qtdHoras = scanner.nextInt();
                double valorHoras = scanner2.nextDouble();

                Servico servico = new Servico(descricao, codigo, qtdHoras, valorHoras);
                carrinho.adicionarVenda(servico);

            } else if (opcao == 4) {
                System.out.println("Itens no carrinho: \n");
                carrinho.exibeItensCarrinho();

            } else if (opcao == 5) {
                System.out.println("Valor da venda: \n");
                System.out.println(carrinho.calculaTotalVenda());

            } else if (opcao == 6) {
                loop = false;
                    System.out.println("Você finalizou a compra!");
            }
        }
    }
}
