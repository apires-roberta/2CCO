import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        ControleBonus controleBonus = new ControleBonus(new ArrayList<>());

        Professor professor = new Professor("Roberta",3,30.0);
        Coordenador coordenador = new Coordenador("Paula", 2,50.0, 4, 20.0);

        controleBonus.adicionarBonus(professor);
        controleBonus.adicionarBonus(coordenador);

        controleBonus.exibeItensLista();

        System.out.println(controleBonus.calculoTotalBonus());
    }
}
