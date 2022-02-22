import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    List<Bonus> Controle = new ArrayList<>();

    public ControleBonus(List<Bonus> controle) {
        Controle = controle;
    }

    public void adicionarBonus(Bonus b){
        Controle.add(b);
    }

    public void exibeItensLista(){
        for(Bonus b : Controle){
            System.out.println(b);
        }
    }

    public Double calculoTotalBonus(){
        Double valor = 0.0;
        for(Bonus b : Controle){
            valor += b.getValorBonus();
        }
        return valor;
    }
}
