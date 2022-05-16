
public class Teste {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(150);
//        pilha.push(2);
//        pilha.push(1);
//        pilha.push(0);
//        pilha.push(1);
//        pilha.push(2);

//        System.out.println("topo --> |" + pilha.pop() + "|");
//        System.out.println("         |" + pilha.pop() + "|");
//        System.out.println("         |" + pilha.pop() + "|");
//        System.out.println("         |" + pilha.pop() + "|");
//        System.out.println("         |" + pilha.pop() + "|");

        int[] vetor = {2,1,0,1,2};

        System.out.println(pilha.ehPolindromo(vetor));

        Pilha pilha2 = new Pilha(10);
        pilha2.divisaoBinaria(10);

        PilhaObj<String> pilhaObj = new PilhaObj<>(10);

        pilhaObj.push("Olá \n");
        pilhaObj.push("Olá, tudo bem? \n");
        pilhaObj.push("Sim \n");

        pilhaObj.exibe();

        pilhaObj.pop();
        pilhaObj.pop();
        pilhaObj.pop();

        PilhaObj<Character> pilhaReversa = new PilhaObj<>(10);

        String frase = "od ahlip A";

        char[] fraseChar = frase.toCharArray();

        for(int i = 0; i < fraseChar.length; i++){
            pilhaReversa.push(fraseChar[i]);
        }

        System.out.println(pilhaReversa.exibeInvertida());
    }

}
