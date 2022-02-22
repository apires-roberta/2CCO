public abstract class Aluno {
    private Integer ra;
    private String nome;

    public Aluno(Integer ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }

    public abstract Double calcMedia();

    @Override
    public String toString() {
        return "Aluno{" +
                "ra=" + ra +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Integer getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }
}
