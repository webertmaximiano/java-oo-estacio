package ArvoreBinaria;

public class main {
    public static void main(String[] args) {
        // Criando a árvore de exemplo
        No raiz = new No(25);
        raiz.esq = new No(24);
        raiz.dir = new No(27);
        raiz.esq.esq = new No(23);
        raiz.dir.esq = new No(26);
        raiz.dir.dir = new No(28);
        raiz.dir.dir.dir = new No(29);

        // Executando a travessia em pré-ordem
        System.out.println("------------- Inicio Pre Ordem----------");
        Arvore arvore = new Arvore();
        arvore.preOrdem(raiz);

        System.out.println("------------- Inicio Simetrica----------");
        // Executando a travessia em ordem simétrica
        arvore.simetrica(raiz);

        System.out.println("------------- Inicio Pre Ordem Nao Recursiva----------");
        // Executando a travessia em pós-ordem
        arvore.preOrdemNaoRecursiva(raiz);

        System.out.println("------------- Inicio Ordem Simetrica Nao Recursiva----------");
        // Executando a travessia em pós-ordem
        arvore.ordemSimetricaNaoRecursiva(raiz);

        System.out.println("------------- Inicio Pos Ordem Nao Recursiva----------");
        // Executando a travessia em pós-ordem
        arvore.posOrdemNaoRecursiva(raiz);

        System.out.println("------------- Inicio Busca Arvore Binaria----------");

        // Criando uma árvore de exemplo
        No no1 = new No(10);
        No no2 = new No(5);
        No no3 = new No(15);
        No no4 = new No(3);
        No no5 = new No(8);
        No no6 = new No(12);
        No no7 = new No(18);

        no1.esq = no2;
        no1.dir = no3;
        no2.esq = no4;
        no2.dir = no5;
        no3.esq = no6;
        no3.dir = no7;

        Arvore arvore2 = new Arvore();
        arvore2.raiz = no1;

        int chaveBusca = 18;
        No pai = new No(-1); // Inicializar com valor inválido
        boolean[] encontrada = {false}; // Inicializar com false
        No noEncontrado = arvore2.busca(chaveBusca, arvore2.raiz, new No[]{pai}, encontrada);

        if (encontrada[0]) {
            System.out.println("Chave encontrada: " + noEncontrado.chave);
            System.out.println("Pai do nó encontrado: " + pai.chave);
        } else {
            System.out.println("Chave não encontrada");
        }

        System.out.println("--- Inserindo No na Arvore Binaria ----");
        Arvore arvore3 = new Arvore();

        arvore3.inserir(10);
        System.out.println("Inseriu o primeiro");
        arvore3.inserir(5);
        arvore3.inserir(15);
        arvore3.inserir(3);
        arvore3.inserir(8);
        arvore3.inserir(12);
        arvore3.inserir(18);
        System.out.println("Inseriu o ultimo");

        System.out.println("------------- Inicio Remover No na Arvore Binaria----------");
        Arvore arvore4 = new Arvore();

        // Inserir elementos na árvore
        arvore4.inserir(50);
        arvore4.inserir(30);
        arvore4.inserir(20);
        arvore4.inserir(40);
        arvore4.inserir(70);
        arvore4.inserir(60);
        arvore4.inserir(80);

        // Exibir árvore antes da remoção
        System.out.println("Árvore antes da remoção:");
        arvore4.preOrdem(arvore4.raiz);

        // Remover um nó
        int chaveRemover = 30;
        boolean removido = arvore4.remover(chaveRemover);

        if (removido) {
            System.out.println("Nó com chave " + chaveRemover + " removido com sucesso.");
        } else {
            System.out.println("Nó com chave " + chaveRemover + " não encontrado.");
        }

        // Exibir árvore após a remoção
        System.out.println("Árvore após a remoção:");
        arvore.preOrdem(arvore.raiz);

    }
}
