package com.c202211057robertaaparecidapires.c202211057robertaaparecidapires.entidade;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

    @Id // do pacote javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @NotBlank // apenas para texto (String)
    @Size(min = 4, max = 12)
    private String login;

    @NotNull
    @NotBlank // apenas para texto (String)
    @Size(min = 4, max = 8)
    private String senha;

    @NotNull
    @NotBlank // apenas para texto (String)
    @Size(min = 10, max = 30)
    private String nome;

    private boolean autenticado;

    public boolean autenticar(String login, String senha) {
        autenticado = login.equals(this.login) && senha.equals(this.senha);
        return autenticado;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}
