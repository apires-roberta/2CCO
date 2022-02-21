public class Coordenador implements Bonus {

    //Atributos
    private String nome;
    private int qtdHoraCoordSem;
    private Double valorHoraCoord;

    //Construtor
    public Coordenador(String nome, int qtdHoraCoordSem, Double valorHoraCoord) {
        this.nome = nome;
        this.qtdHoraCoordSem = qtdHoraCoordSem;
        this.valorHoraCoord = valorHoraCoord;
    }

    //Metodos
    @Override
    public Double getValorBonus() {
        return (qtdHoraCoordSem * valorHoraCoord) * (4.5 * 0.2);
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "nome='" + nome + '\'' +
                ", qtdHoraCoordSem=" + qtdHoraCoordSem +
                ", valorHoraCoord=" + valorHoraCoord +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdHoraCoordSem() {
        return qtdHoraCoordSem;
    }

    public void setQtdHoraCoordSem(int qtdHoraCoordSem) {
        this.qtdHoraCoordSem = qtdHoraCoordSem;
    }

    public Double getValorHoraCoord() {
        return valorHoraCoord;
    }

    public void setValorHoraCoord(Double valorHoraCoord) {
        this.valorHoraCoord = valorHoraCoord;
    }
}
