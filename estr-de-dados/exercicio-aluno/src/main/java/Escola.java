import java.util.ArrayList;
import java.util.List;

public class Escola {
    private String nome;
    private List<Aluno> alunos;

    public Escola(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public void adicionaAluno(Aluno a) {
        alunos.add(a);
    }

    public void exibeTodos() {
        for ( Aluno a: alunos) {
            System.out.println(a);
        }
    }

    public void exibeAlunoGraduacao() {
        for (Aluno x : alunos) {
            if(x instanceof AlunoGraduacao) {
                System.out.println(x);
            }
        }
    }

    public void exibeAprovados() {
        for (Aluno x : alunos) {
            if (x.calcMedia() >= 6) {
                System.out.println(x);
            }
        }
    }

    public void buscaAluno(Integer ra) {
        for( Aluno x : alunos) {
            if (x.getRa().equals(ra)) {
                System.out.println(x);
            } else System.out.println("Aluno não encontrado");
        }
    }
}
