public class UserFuncionario extends Usuario {


    public UserFuncionario(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public void realizarPost(String post) {
        String emailValido = "";
        emailValido = getEmail();

        String senhaValido = "";
        senhaValido = getSenha();

        if (getEmail().equals(emailValido) && getSenha().equals(senhaValido)) {
            System.out.println(String.format("Você realizou um post como funcionario %s", post));
        } else {
            System.out.println(String.format("Infelizmente seu email ou senha está errado, não foi possível realizar o post como funcionario"));
        }

    }

    @Override
    public void excluirPost(String post) {
        String emailValido = "";
        emailValido = getEmail();

        String senhaValido = "";
        senhaValido = getSenha();

        if (getEmail().equals(emailValido) && getSenha().equals(senhaValido)) {
            System.out.println(String.format("Você excluiu um post como funcionario %s", post));
        } else {
            System.out.println(String.format("Infelizmente seu email ou senha está errado, não foi possível excluir o post como funcionario"));
        }
    }

    @Override
    public void logar() {
        String emailValido = "";
        emailValido = getEmail();

        String senhaValido = "";
        senhaValido = getSenha();

        if (getEmail().equals(emailValido) && getSenha().equals(senhaValido)) {
            System.out.println(String.format("Você se logou como funcionario"));
        } else {
            System.out.println(String.format("Infelizmente seu email ou senha está errado, não foi logar como funcionario"));
        }
    }

    @Override
    public void deslogar() {
        System.out.println(String.format("Você deslogou como funcionario"));

    }


}
