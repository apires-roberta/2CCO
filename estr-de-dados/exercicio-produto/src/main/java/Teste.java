import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        List<Produto> listaProd = new ArrayList<>();

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

        prod1.toString();
        System.out.printf("%06d %-14s %6.2f %7s %14.3f\n", prod1.getCodProduto(),
                prod1.getNome(),
                prod1.getPreco(),
                prod1.getAvaliacao(),
                prod1.calcularFaturamento());

        System.out.printf("%06d %-14s %6.2f %7s %14.3f\n", prod2.getCodProduto(),
                prod2.getNome(),
                prod2.getPreco(),
                prod2.getAvaliacao(),
                prod2.calcularFaturamento());

        System.out.printf("%06d %-14s %6.2f %7s %14.3f\n", prod3.getCodProduto(),
                prod3.getNome(),
                prod3.getPreco(),
                prod3.getAvaliacao(),
                prod3.calcularFaturamento());

        System.out.printf("%06d %-14s %6.2f %7s %14.3f\n", prod4.getCodProduto(),
                prod4.getNome(),
                prod4.getPreco(),
                prod4.getAvaliacao(),
                prod4.calcularFaturamento());

        System.out.printf("%06d %-14s %6.2f %7s %14.3f\n", prod5.getCodProduto(),
                prod5.getNome(),
                prod5.getPreco(),
                prod5.getAvaliacao(),
                prod5.calcularFaturamento());


    }
}
