public class Professor implements Bonus{

    //Atributos
    private String nome;
    private int qtdAulasSem;
    private Double valorHoraAula;

    //Construtor
    public Professor(String nome, int qtdAulasSem, Double valorHoraAula) {
        this.nome = nome;
        this.qtdAulasSem = qtdAulasSem;
        this.valorHoraAula = valorHoraAula;
    }

    //Metodos
    @Override
    public Double getValorBonus() {
        return (qtdAulasSem * valorHoraAula) * (4.5 * 0.15);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", qtdAulasSem=" + qtdAulasSem +
                ", valorHoraAula=" + valorHoraAula +
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

    public Double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(Double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }
}
