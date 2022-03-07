import org.w3c.dom.ls.LSOutput;

public class BrinquedoIngresso implements Impostos{
    //Atributos
    private int codigo;
    private String nome;
    private Double valorIngresso;
    private int qtdIngressoVendido;

    //Construtor
    public BrinquedoIngresso(int codigo, String nome, Double valorIngresso, int qtdIngressoVendido) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorIngresso = valorIngresso;
        this.qtdIngressoVendido = qtdIngressoVendido;
    }

    //Metodos
    @Override
    public Double getValorImposto() {
        Double valor = (getValorIngresso() * getQtdIngressoVendido()) * 0.15;
        return valor;
    }

    public Double getRenda(){
        Double renda = getValorIngresso() * getQtdIngressoVendido();
        return renda;
    }

    @Override
    public String toString() {
        return "BrinquedoIngresso{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", valorIngresso=" + valorIngresso +
                ", qtdIngressoVendido=" + qtdIngressoVendido +
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

    public Double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(Double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public int getQtdIngressoVendido() {
        return qtdIngressoVendido;
    }

    public void setQtdIngressoVendido(int qtdIngressoVendido) {
        this.qtdIngressoVendido = qtdIngressoVendido;
    }


}
