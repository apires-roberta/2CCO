public class Servico implements Vendavel{

    //Atributos
    private String descricao;
    private int codigo;
    private int qtdHoras;
    private double valorHoras;

    //Construtor
    public Servico(String descricao, int codigo, int qtdHoras, double valorHoras) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.qtdHoras = qtdHoras;
        this.valorHoras = valorHoras;
    }

    //Metodos
    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + descricao + '\'' +
                ", codigo=" + codigo +
                ", qtdHoras=" + qtdHoras +
                ", valorHoras=" + valorHoras +
                '}';
    }

    @Override
    public double getValorVenda() {
        return qtdHoras * valorHoras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(int qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public double getValorHoras() {
        return valorHoras;
    }

    public void setValorHoras(double valorHoras) {
        this.valorHoras = valorHoras;
    }
}
