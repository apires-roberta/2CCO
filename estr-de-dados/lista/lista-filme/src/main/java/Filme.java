public class Filme {

    // Atributos
    private int idFilme;
    private String nome;
    private double nota;
    private String genero;
    private int idade;

    // Construtor
    public Filme(int idFilme, String nome, double nota, String genero, int idade) {
        this.idFilme = idFilme;
        this.nome = nome;
        this.nota = nota;
        this.genero = genero;
        this.idade = idade;
    }

    // Getters e Setters
    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // toString
    @Override
    public String toString() {
        return String.format("%05d %-30s %5.2f %10s %2d",
                idFilme,
                nome,
                nota,
                genero,
                idade);
    }
}
