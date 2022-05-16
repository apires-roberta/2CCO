public class BrinquedoAlugado implements Impostos{
    //Atributos
    private int codigo;
    private String nome;
    private Double valorHora;
    private int qtdHoraAlugada;

    //Contrutor
    public BrinquedoAlugado(int codigo, String nome, Double valorHora, int qtdHoraAlugada) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorHora = valorHora;
        this.qtdHoraAlugada = qtdHoraAlugada;
    }

    //Metodos
    @Override
    public Double getValorImposto() {
        Double valor = (getValorHora() * getQtdHoraAlugada()) * 0.10;
        return valor;
    }

    public Double getRenda(){
        Double renda = getValorHora() * getQtdHoraAlugada();
        return renda;
    }

    @Override
    public String toString() {
        return "BrinquedoAlugado{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", valorHora=" + valorHora +
                ", qtdHoraAlugada=" + qtdHoraAlugada +
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

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public int getQtdHoraAlugada() {
        return qtdHoraAlugada;
    }

    public void setQtdHoraAlugada(int qtdHoraAlugada) {
        this.qtdHoraAlugada = qtdHoraAlugada;
    }
}
