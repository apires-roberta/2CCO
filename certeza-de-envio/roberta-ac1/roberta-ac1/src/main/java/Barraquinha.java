public class Barraquinha implements Impostos{
    //Atributos
    private int codigo;
    private String nome;
    private Double vendas;
    private int qtdVendas;

    //Contrutor
    public Barraquinha(int codigo, String nome, Double vendas, int qtdVendas) {
        this.codigo = codigo;
        this.nome = nome;
        this.vendas = vendas;
        this.qtdVendas = qtdVendas;
    }

    //Metodos

    public Double getRenda(){
        Double valor = getVendas() * getQtdVendas();
        return valor;
    }

    @Override
    public Double getValorImposto() {
        Double valor = (getVendas() * getQtdVendas()) * 0.30;
        return valor;
    }

    @Override
    public String toString() {
        return "Barraquinha{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", vendas=" + vendas +
                ", qtdVendas=" + qtdVendas +
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

    public Double getVendas() {
        return vendas;
    }

    public void setVendas(Double vendas) {
        this.vendas = vendas;
    }

    public int getQtdVendas() {
        return qtdVendas;
    }

    public void setQtdVendas(int qtdVendas) {
        this.qtdVendas = qtdVendas;
    }
}
