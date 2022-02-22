public class TesteAluno {
    public static void main(String[] args) {
        AlunoFundamental alunoFund = new AlunoFundamental(1, "Roberta", 7.0, 7.0, 7.0, 7.0);
        AlunoGraduacao alunoGrad = new AlunoGraduacao(2, "Paula", 10.0, 10.0);
        AlunoPos alunoP = new AlunoPos(3, "Abner", 8.0, 9.0, 10.0);

        System.out.println(alunoFund);
        System.out.println(alunoGrad);
        System.out.println(alunoP);

        Escola sptech = new Escola("Sptech");

        sptech.adicionaAluno(alunoFund);
        sptech.buscaAluno(1);
        sptech.buscaAluno(2);
        sptech.adicionaAluno(alunoGrad);
        sptech.adicionaAluno(alunoP);
        sptech.exibeAlunoGraduacao();
        sptech.exibeAprovados();
        sptech.exibeTodos();
    }
}
