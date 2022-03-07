public class main {
    public static void main(String[] args) {
        UserFuncionario funcionario1 = new UserFuncionario("Roberta Pires", "func1@gmail.com", "1234");
        UserPublico user1 = new UserPublico("Abner Nunes","user1@gmail.com", "4321");

        funcionario1.realizarPost("Olá! Sou um funcionário!");
        funcionario1.excluirPost("Tchau!");

        funcionario1.logar();
        funcionario1.deslogar();

        user1.realizarPost("Olá! Sou um usuário!");
        user1.excluirPost("Tchau :)");

        user1.logar();
        user1.deslogar();
    }
}
