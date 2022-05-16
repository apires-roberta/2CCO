import java.util.ArrayList;
import java.util.List;

public class ControleImposto {

    List<Impostos> Controle = new ArrayList<>();

    public ControleImposto(List<Impostos> controle) {

        Controle = controle;
    }

    public void adicionarImposto(Impostos i) {
        Controle.add(i);
    }

    public Double calculaImpostos() {
        Double valor = 0.0;
        for (Impostos i : Controle) {
            valor += i.getValorImposto();
        }
        return valor;
    }

    public void exibeItensList() {
        for (Impostos i : Controle) {
            System.out.println(i);
        }
    }
}
