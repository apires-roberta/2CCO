public class Teste {

    public static void main(String[] args) {
        int indRetornado;

        ListaObj<String> lista = new ListaObj(5) {
            @Override
            public void adiciona(int x, int y) {

            }
        };


        lista.exibe();

        lista.adiciona("A");
        lista.adiciona("B");
        lista.adiciona("C");

        lista.exibe();

        lista.adiciona("D");
        lista.adiciona("F");
        System.out.println("\nTentando adicionar o sexto elemento");
        lista.adiciona("G");

        lista.exibe();

        System.out.println("\nBuscando o elemento C");
        indRetornado = lista.busca("C");
        if (indRetornado == -1) {
            System.out.println("Elemento C não foi encontrado");
        }
        else {
            System.out.println("Elemento C encontrado no índice " + indRetornado);
        }

        System.out.println("\nBuscando o elemento D");
        indRetornado = lista.busca("D");
        if (indRetornado == -1) {
            System.out.println("Elemento D não foi encontrado");
        }
        else {
            System.out.println("Elemento D encontrado no índice " + indRetornado);
        }

        System.out.println("\nRemovendo o elemento do índice 4");
        if (lista.removePeloIndice(4)) {
            System.out.println("Removido elemento do índice 4");
        }
        else {
            System.out.println("Remoção inválida");
        }

        lista.exibe();

        System.out.println("\nRemovendo o elemento do índice 0");
        if (lista.removePeloIndice(0)) {
            System.out.println("Removido elemento do índice 0");
        }
        else {
            System.out.println("Remoção inválida");
        }

        lista.exibe();

        System.out.println("\nRemovendo o elemento do índice 7");
        if (lista.removePeloIndice(7)) {
            System.out.println("Removido elemento do índice 7");
        }
        else {
            System.out.println("Remoção inválida");
        }

        lista.exibe();

        System.out.println("\nRemovendo o elemento C");
        if (lista.removeElemento("C")) {
            System.out.println("Removido elemento C");
        }
        else {
            System.out.println("Remoção inválida");
        }

        lista.exibe();

        System.out.println("\nRemovendo o elemento B");
        if (lista.removeElemento("B")) {
            System.out.println("Removido elemento B");
        }
        else {
            System.out.println("Remoção inválida");
        }

        lista.exibe();

    }
}
