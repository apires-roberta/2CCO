public class Aluno {

    private int ra;
    private String nome;
    private double nota;

    public Aluno(int ra, String nome, double nota) {
        this.ra = ra;
        this.nome = nome;
        this.nota = nota;
    }

    @Override
    public String toString() {
        String texto1 = String.valueOf(System.out.printf("%-10s %-30s %5s \n", "CODIGO", "NOME", "NOTA"));
        String texto2 = String.valueOf(System.out.printf("%-10d %-30s %5.2f\n", ra, nome, nota));
        return texto1 + texto2;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
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
}
