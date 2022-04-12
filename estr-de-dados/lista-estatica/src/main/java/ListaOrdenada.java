public class ListaOrdenada extends ListaEstatica {


    public ListaOrdenada(int tamanho) {
        super(tamanho);
    }

    @Override
    public void adiciona(int novoElemento, int posicaoInserida) {

        if(vetor.length == nroElem) {
            System.out.println("Erro a lista está vazia");
        }
            else {
                if(posicaoInserida==0) {
                    adicionainicio(novoElemento);
                }
                else {
                    if(posicaoInserida > nroElem) {
                        System.out.println("Erro posição inválida");
                    }
                    else {
                        for(int count= nroElem; count>= posicaoInserida;count--) {
                            vetor[count] = vetor[count - 1];
                        }
                        vetor[posicaoInserida] = novoElemento;
                        nroElem++;
                    }
                }
            }
    }


}




