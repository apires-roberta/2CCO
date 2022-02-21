public class Professor implements Bonus{

    //Atributos
    private String nome;
    private int qtdAulasSem;
    private Double qtdValorAula;

    //Construtor
    public Professor(String nome, int qtdAulasSem, Double qtdValorAula) {
        this.nome = nome;
        this.qtdAulasSem = qtdAulasSem;
        this.qtdValorAula = qtdValorAula;
    }

    //Metodos
    @Override
    public Double getValorBonus() {
        return (qtdAulasSem * qtdValorAula) * (4.5 * 0.15);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", qtdAulasSem=" + qtdAulasSem +
                ", qtdValorAula=" + qtdValorAula +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdAulasSem() {
        return qtdAulasSem;
    }

    public void setQtdAulasSem(int qtdAulasSem) {
        this.qtdAulasSem = qtdAulasSem;
    }

    public Double getQtdValorAula() {
        return qtdValorAula;
    }

    public void setQtdValorAula(Double qtdValorAula) {
        this.qtdValorAula = qtdValorAula;
    }
}
