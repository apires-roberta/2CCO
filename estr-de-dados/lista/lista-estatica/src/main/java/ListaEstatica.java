public abstract class ListaEstatica {

    // Atributos
    int[] vetor;
     int nroElem;


    // Construtor
    // Recebe como argumento o tamanho máximo do vetor
    public ListaEstatica(int tamanho) {
        vetor = new int[tamanho];
        nroElem = 0;
    }

    // Métodos
    public void adiciona(int elemento) {
        if (nroElem >= vetor.length) {
            System.out.println("Lista está cheia");
        }
        else {
            vetor[nroElem++] = elemento;
        }
    }


    public void exibe() {
        if (nroElem == 0) {
            System.out.println("\nA lista está vazia.");
        }
        else {
            System.out.println("\nElementos da lista:");
            for (int i = 0; i < nroElem; i++) {
                System.out.print(vetor[i] + "\t");
            }
            System.out.println();
        }
    }


    public int busca(int elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i] == elementoBuscado) {   // se encontrou
                return i;                        // retorna seu índice
            }
        }
        return -1;
    }


    public boolean removePeloIndice (int indice) {
        if (indice < 0 || indice >= nroElem) {
            System.out.println("\nÍndice inválido!");
            return false;
        }

        for (int i = indice; i < nroElem - 1; i++) {
            vetor[i] = vetor[i+1];
        }
        nroElem--;
        return true;
    }


    public boolean removeElemento(int elementoARemover) {
        return removePeloIndice(busca(elementoARemover));
    }


    public boolean substituiElemento(int valorAntigo, int ValorNovo) {
        for (int count = 0; count < vetor.length; count++){
            if (valorAntigo == vetor[count]){
                vetor[count] = ValorNovo;
                return true;
            }

        }
        System.out.println("Valor não encontrado");
        return false;
    }

    public int contaOcorrencias(int valorProcurado) {
        int NumeroDeVezes = 0;
        for (int count = 0; count < vetor.length; count++) {
            if (valorProcurado == vetor[count]){
                NumeroDeVezes++;
            }
        }
        return NumeroDeVezes;
    }

    public boolean adicionainicio(int novoElemento) {
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

    public abstract void adiciona(int x, int y);
}
