import java.util.Scanner;

public class ExercicioTurma {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String[] T1 = new String[10];
        String[] T2 = new String[10];
        String[] aluno = new String[10];

        int qtdT1=0;
        int qtdT2 = 0;

        for (int i = 0; i < (aluno.length ); i++) {
            System.out.println("Digite o " + (i + 1) + "° aluno");
            aluno[i] = leitor.nextLine();

            System.out.println("Digite a turma");

            String turma = leitor.nextLine();

            if (turma.equals("T1")) {
                T1[i] = aluno[i];
                T2[i] = "null";
            } else if (turma.equals("T2")) {
                T2[i] = aluno[i];
                T1[i] = "null";
            } else {
                System.out.println("ERRO");
            }
        }

        System.out.println("Alunos da turma 1: \n");
        for (int i = 0; i < aluno.length ; i++){
            if (!(T1[i].equals("null"))) {
                qtdT1++;
                System.out.println(T1[i]);

            }
        }

        System.out.println("Qtd alunos T1:" + qtdT1);


        System.out.println("Alunos da turma 2:\n");
        for (int i = 0; i < aluno.length ; i++){
            if (!(T2[i].equals("null"))) {
                qtdT2++;
                System.out.println(T2[i]);
            }
        }

        System.out.println("Qtd alunos T2:" + qtdT2);

    }
}


