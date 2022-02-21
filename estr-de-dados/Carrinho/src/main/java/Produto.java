public abstract class Produto implements Vendavel{

    //Atributos
    private int codigo;
    private String nome;
    private double precoCusto;

    //Construtor
    public Produto(int codigo, String nome, double precoCusto) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoCusto = precoCusto;
    }

    //Metodos
    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", precoCusto=" + precoCusto +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }
}
