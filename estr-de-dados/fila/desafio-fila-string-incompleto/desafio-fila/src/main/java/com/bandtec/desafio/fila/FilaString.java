package com.bandtec.desafio.fila;

public class FilaString {
    // Atributos
    private int tamanho;
    private String[] fila;

    // Construtor
    public FilaString(int capaciade) {

    }

    // Métodos

    /* Método isEmpty() - retorna true se a fila está vazia e false caso contrário */
    public boolean isEmpty() {
        if (tamanho == 0 && fila.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    /* Método isFull() - retorna true se a fila está cheia e false caso contrário */
    public boolean isFull() {
        if (tamanho == fila.length) {
            return true;
        }
        return false;
    }

    /* Método insert - recebe um elemento e insere esse elemento na fila
                       no índice tamanho, e incrementa tamanho
                       Retornar IllegalStateException caso a fila esteja cheia
     */
    public void insert(String info) {
            if (isFull()) {
                fila[tamanho] = info;
                tamanho++;
            } else {
                return IllegalStateException;
        }
    }

    /* Método peek - retorna o primeiro elemento da fila, sem removê-lo */
    public String peek() {

        return "";
    }

    /* Método poll - remove e retorna o primeiro elemento da fila, se a fila não estiver
       vazia. Quando um elemento é removido, a fila "anda", e tamanho é decrementado
     */
    public String poll() {
        return "";
    }

    /* Método exibe() - exibe o conteúdo da fila */
    public void exibe() {

    }

    public int getTamanho() {
        return 0;
    }
}
