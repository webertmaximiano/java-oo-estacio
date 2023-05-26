package ArvoreBinaria;

public class main {
    public static void main(String[] args) {
        // Criando a árvore de exemplo
        No raiz = new No(1);
        raiz.esq = new No(2);
        raiz.dir = new No(3);
        raiz.esq.esq = new No(4);
        raiz.esq.dir = new No(5);

        // Executando a travessia em pré-ordem
        Arvore arvore = new Arvore();
        arvore.preOrdem(raiz);
    }
}
