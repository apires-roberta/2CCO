package com.sptech.projeto2;

public class Pais {

    private String nome;
    private int medalhasOuros;
    private int medalhasPrata;
    private int medalhasBronze;

    public Pais(String nome, int medalhasOuros, int medalhasPrata, int medalhasBronze) {
        this.nome = nome;
        this.medalhasOuros = medalhasOuros;
        this.medalhasPrata = medalhasPrata;
        this.medalhasBronze = medalhasBronze;
    }

    public Pais() {
    }

    public int getTotalMedalhas(){
        return medalhasBronze + medalhasPrata + medalhasOuros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMedalhasOuros() {
        return medalhasOuros;
    }

    public void setMedalhasOuros(int medalhasOuros) {
        this.medalhasOuros = medalhasOuros;
    }

    public int getMedalhasPrata() {
        return medalhasPrata;
    }

    public void setMedalhasPrata(int medalhasPrata) {
        this.medalhasPrata = medalhasPrata;
    }

    public int getMedalhasBronze() {
        return medalhasBronze;
    }

    public void setMedalhasBronze(int medalhasBronze) {
        this.medalhasBronze = medalhasBronze;
    }
}
