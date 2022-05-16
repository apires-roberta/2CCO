import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        //A classe Barraquinha é um objeto onde os usuários podem cadastras suas barracas de comida no parque
        //ela se encaixa implementando o metodo getValorImposto() da classe Interface
        //seu cálculo é feito pelo valor das vendas * quantidade de vendas * 0.30

        ControleImposto controleImposto = new ControleImposto(new ArrayList<>());

        BrinquedoIngresso brinquedoIngresso1 = new BrinquedoIngresso(111,"Montanha Russa",5.00,50);
        BrinquedoAlugado brinquedoAlugado1 = new BrinquedoAlugado(222,"Bicicleta", 2.00,24);
        Barraquinha barraquinha1 = new Barraquinha(333, "Barraquinha de Pipoca", 500.0, 200);
        Socio socio1 = new Socio("Roberta Pires", 500.0);

        System.out.println(brinquedoIngresso1.getNome() + " renda: " + brinquedoIngresso1.getRenda());
        System.out.println(brinquedoIngresso1.getNome() + " valor imposto: " + brinquedoIngresso1.getValorImposto());

        System.out.println("-------------------");

        System.out.println(brinquedoAlugado1.getNome() + " renda: " + brinquedoAlugado1.getRenda());
        System.out.println(brinquedoAlugado1.getNome() + " valor imposto: " + brinquedoAlugado1.getValorImposto());

        System.out.println("-------------------");

        System.out.println(barraquinha1.getNome() + " renda: " + barraquinha1.getRenda());
        System.out.println(barraquinha1.getNome() + " valor imposto: " + barraquinha1.getValorImposto());

        System.out.println("-------------------");

        System.out.println(socio1.getNome() + " socio valor imposto: " + socio1.getValorImposto());

        System.out.println("-------------------");

        controleImposto.adicionarImposto(brinquedoIngresso1);
        controleImposto.adicionarImposto(brinquedoAlugado1);
        controleImposto.adicionarImposto(barraquinha1);
        controleImposto.adicionarImposto(socio1);

        controleImposto.exibeItensList();



    }
}
