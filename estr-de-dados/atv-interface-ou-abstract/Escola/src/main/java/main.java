import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        ControleBonus controleBonus = new ControleBonus(new ArrayList<>());

        Professor professor = new Professor("Roberta", 4, 40.0);
        Coordenador coordenador = new Coordenador("Paula", 3, 30.0);

        professor.getValorBonus();
        coordenador.getValorBonus();

        controleBonus.adicionaBonus(professor);
        controleBonus.adicionaBonus(coordenador);

        controleBonus.exibeItensLista();

        System.out.println(controleBonus.calculoTotalBonus());


    }
}
