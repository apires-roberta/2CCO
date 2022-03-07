public abstract class Usuario {
    //Atributos
    private String nome;
    private String email;
    private String senha;

    //Contrutor
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    //Metodos
    public abstract void realizarPost(String post);

    public abstract void excluirPost(String post);

    public abstract void logar();

    public abstract void deslogar();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
