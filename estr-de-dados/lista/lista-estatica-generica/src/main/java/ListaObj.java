public abstract class ListaObj<T> {

    // Atributos
    private T[] vetor;
    int nroElem;


    // Construtor
    // Recebe como argumento o tamanho máximo do vetor
    public ListaObj(int tamanho) {
        vetor = (T[]) new Object[tamanho];
        nroElem = 0;
    }

    // Métodos
    public void adiciona(T elemento) {
        if (nroElem >= vetor.length) {
            System.out.println("Lista está cheia");
        } else {
            vetor[nroElem++] = elemento;
        }
    }


    public void exibe() {
        if (nroElem == 0) {
            System.out.println("\nA lista está vazia.");
        } else {
            System.out.println("\nElementos da lista:");
            for (int i = 0; i < nroElem; i++) {
                System.out.print(vetor[i] + "\t");
            }
            System.out.println();
        }
    }


    public int busca(T elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elementoBuscado)) {   // se encontrou
                return i;                        // retorna seu índice
            }
        }
        return -1;
    }


    public boolean removePeloIndice(int indice) {
        if (indice < 0 || indice >= nroElem) {
            System.out.println("\nÍndice inválido!");
            return false;
        }

        for (int i = indice; i < nroElem - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        nroElem--;
        return true;
    }


    public boolean removeElemento(T elementoARemover) {
        return removePeloIndice(busca(elementoARemover));
    }


    public boolean substituiElemento(T valorAntigo, T ValorNovo) {
        for (int count = 0; count < vetor.length; count++) {
            if (valorAntigo == vetor[count]) {
                vetor[count] = ValorNovo;
                return true;
            }

        }
        System.out.println("Valor não encontrado");
        return false;
    }

    public int contaOcorrencias(T valorProcurado) {
        int NumeroDeVezes = 0;
        for (int count = 0; count < vetor.length; count++) {
            if (valorProcurado == vetor[count]) {
                NumeroDeVezes++;
            }
        }
        return NumeroDeVezes;
    }

    public boolean adicionainicio(T novoElemento) {
        if (nroElem != vetor.length) {
            for (int i = nroElem; i >= 1; i--) {
                vetor[i] = vetor[i - 1];
            }

            nroElem++;

            vetor[0] = novoElemento;
            return true;
        }
        System.out.println("Lista cheia");
        return false;
    }

    public int getTamanho(T vetor) {
        return nroElem;
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return null;
        } else {
            return vetor[indice];
        }

    }

    public void limpa(){
        nroElem = 0;
    }


    public abstract void adiciona(int x, int y);
}


