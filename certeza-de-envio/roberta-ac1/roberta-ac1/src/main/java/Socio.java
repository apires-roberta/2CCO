public class Socio implements Impostos{
    //Atributos
    private String nome;
    private Double honorario;

    //Construtor
    public Socio(String nome, Double honorario) {
        this.nome = nome;
        this.honorario = honorario;
    }

    //Metodos
    @Override
    public Double getValorImposto() {
        return getHonorario() * 0.25;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "nome='" + nome + '\'' +
                ", honorario=" + honorario +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getHonorario() {
        return honorario;
    }

    public void setHonorario(Double honorario) {
        this.honorario = honorario;
    }
}
