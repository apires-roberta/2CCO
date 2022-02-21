import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    List<Vendavel> cart = new ArrayList<>();

    public void adicionarVenda(Vendavel t){
        cart.add(t);
    }

    public double calculaTotalVenda(){
        Double valor = 0.0;
        for (Vendavel t : cart){
            valor += t.getValorVenda();
        }
        return valor;
    }

    public void exibeItensCarrinho(){
        for(Vendavel t : cart){
            System.out.println(t);
        }
    }
}
