public class Dvd extends Produto{

    //Atributos
    private String gravadora;

    //Construtor
    public Dvd(int codigo, String nome, double precoCusto, String gravadora) {
        super(codigo, nome, precoCusto);
        this.gravadora = gravadora;
    }

    //Metodos
    @Override
    public String toString() {
        return "Dvd{" +
                "gravadora='" + gravadora + '\'' +
                '}';
    }

    @Override
    public double getValorVenda() {

        return getPrecoCusto();
    }

    public String getGravadora() {
        return gravadora;
    }

    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }
}
