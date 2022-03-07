public class UserPublico extends Usuario {

    public UserPublico(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public void realizarPost(String post) {
        String emailValido = "";
        emailValido = getEmail();

        String senhaValido = "";
        senhaValido = getSenha();

        if (getEmail().equals(emailValido) && getSenha().equals(senhaValido)) {
            System.out.println(String.format("Você realizou um post como usuário %s", post));
        } else {
            System.out.println(String.format("Infelizmente seu email ou senha está errado, não foi possível realizar o post como usuário"));
        }

    }

    @Override
    public void excluirPost(String post) {
        String emailValido = "";
        emailValido = getEmail();

        String senhaValido = "";
        senhaValido = getSenha();

        if (getEmail().equals(emailValido) && getSenha().equals(senhaValido)) {
            System.out.println(String.format("Você excluiu um post como usuário %s", post));
        } else {
            System.out.println(String.format("Infelizmente seu email ou senha está errado, não foi possível excluir o post como usuário"));
        }
    }

    @Override
    public void logar() {
        String emailValido = "";
        emailValido = getEmail();

        String senhaValido = "";
        senhaValido = getSenha();

        if (getEmail().equals(emailValido) && getSenha().equals(senhaValido)) {
            System.out.println(String.format("Você se logou como usuário"));
        } else {
            System.out.println(String.format("Infelizmente seu email ou senha está errado, não foi logar como usuário"));
        }
    }

    @Override
    public void deslogar() {
        System.out.println(String.format("Você deslogou como usuário"));
    }
}
