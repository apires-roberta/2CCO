public class Pilha {
    private int topo;
    private int[] pilha;

    public Pilha(int tamanho) {
        this.topo = -1;
        this.pilha = new int[tamanho];
    }

    public boolean isEmpty() {
        if (topo == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (pilha.length - 1 == topo) {
            return true;
        }
        return false;
    }

    public void push(int info) {
        if (!isFull()) {
            pilha[++topo] = info;
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return pilha[topo--];
        } else {
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return topo;
        }
        return -1;
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
        } else {
            for (int i = topo; i > -1; i--) {
                System.out.println(pilha[i]);
            }
        }
    }

    public boolean ehPolindromo(int vetor[]) {

        for (int i = 0; i < vetor.length; i++){
            push(vetor[i]);
        }

        boolean palindromo = false;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == pop()) {
                System.out.println("É palindromo");
                palindromo = true;
            } else {
                System.out.println("Não é palindromo");
                return false;
            }
        }
        return palindromo;
    }

    public void divisaoBinaria(int num){
        String numero = "";

        while(num != 0){
            push(num % 2);
            num = num / 2;
        }

        while(!isEmpty()){
            numero += pop();
        }
        System.out.println(numero);
    }
}
