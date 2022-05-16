public class Coordenador extends Professor {

    //Atributos
    private int qtdHoraCoordSem;
    private Double valorHoraCoord;

    //Construtor
    public Coordenador(String nome, int qtdAulasSem, Double valorHoraAula, int qtdHoraCoordSem, Double valorHoraCoord) {
        super(nome, qtdAulasSem, valorHoraAula);
        this.qtdHoraCoordSem = qtdHoraCoordSem;
        this.valorHoraCoord = valorHoraCoord;
    }

    //Metodos
    @Override
    public Double getValorBonus() {
        return super.getValorBonus() + qtdHoraCoordSem * valorHoraCoord * 4.5 * 0.2;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "qtdHoraCoordSem=" + qtdHoraCoordSem +
                ", valorHoraCoord=" + valorHoraCoord +
                '}';
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
