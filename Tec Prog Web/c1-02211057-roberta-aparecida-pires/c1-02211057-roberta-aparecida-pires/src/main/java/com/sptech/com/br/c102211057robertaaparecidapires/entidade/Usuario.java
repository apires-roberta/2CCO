package com.sptech.com.br.c102211057robertaaparecidapires.entidade;

public class Usuario {
    private String usuario;
    private String senha;
    private String nome;
    private Boolean autenticar = false;

    public Usuario(String usuario, String senha, String nome) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.autenticar = autenticar;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public Boolean getAutenticar() {
        return autenticar;
    }

    public void setAutenticar(Boolean autenticar) {
        this.autenticar = autenticar;
    }
}
