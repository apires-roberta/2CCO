public class App {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(6);
        lista.addElem(1);
        lista.addElem(2);
        lista.addElem(6);
        lista.addElem(4);
        lista.addElem(5);

        lista.buscarElem(6);
        lista.removeIndice(2);
        lista.removeElem(1);
        lista.exibeLista();
    }
}
