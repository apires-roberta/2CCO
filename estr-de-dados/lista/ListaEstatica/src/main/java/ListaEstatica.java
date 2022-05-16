public class ListaEstatica {
    //Atributos
    int[] vetor;
    int nroElem;

    //Construtor
    public ListaEstatica(int tamanho) {
        this.vetor = new int[tamanho];
        this.nroElem = 0;
    }

    //Metodos
    public void addElem(int e) {
        if (nroElem == (vetor.length - 1)) {
            System.out.println("Lista cheia");
        } else {
            nroElem++;
            vetor[nroElem] = e;
        }
    }

    public void exibeLista() {
        for (int i = 1; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public int buscarElem(int e) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == (e)) {
                System.out.println("vetor[" + i + "]" + vetor[i]);
            } else {
                System.out.println(-1);
            }
        }
        return e;
    }

    public boolean removeIndice(int e) {
        boolean vet;
        for (int i = e; i < nroElem - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        nroElem--;
        return true;
    }

    public boolean removeElem(int e) {
        return removeIndice(buscarElem(e));
    }
}
