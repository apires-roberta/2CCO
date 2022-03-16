package sptech.projeto04.entidade;

public class Heroi {

    private String nome;
    private String classe;
    private int ranking;

    public Heroi(String nome, String classe, int ranking) {
        this.nome = nome;
        this.classe = classe;
        this.ranking = ranking;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
