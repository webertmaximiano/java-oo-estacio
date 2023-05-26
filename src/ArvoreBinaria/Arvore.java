package ArvoreBinaria;
import java.util.Stack;
public class Arvore {
    No raiz;
    //percorrer
    public void preOrdem(No p) {
        if (p != null) {
            visita(p);
            preOrdem(p.esq);
            preOrdem(p.dir);
        }
    }

    private void visita(No no) {
        // Fazer algo com o nó visitado
        System.out.println(no.valor);
    }

    public void simetrica(No p) {
        if (p != null) {
            simetrica(p.esq);
            visita(p);
            simetrica(p.dir);
        }
    }

    public void posOrdem(No p) {
        if (p.esq != null) {
            posOrdem(p.esq);
            if (p.dir !=null) {
                posOrdem(p.dir);
            }
            visita(p);
        }
    }

    public void preOrdemNaoRecursiva(No p) {
        if (p == null)
            return;

        Stack<No> pilha = new Stack<>();
        pilha.push(p);

        while (!pilha.empty()) {
            No aux = pilha.pop();
            visita(aux);

            if (aux.dir != null)
                pilha.push(aux.dir);
            if (aux.esq != null)
                pilha.push(aux.esq);
        }
    }

    public void ordemSimetricaNaoRecursiva(No p) {
        if (p == null)
            return;

        Stack<No> pilha = new Stack<>();
        pilha.push(p);
        int momento = 1;

        while (!pilha.empty()) {
            No aux = pilha.pop();

            if (momento == 1) {
                pilha.push(aux);
                if (aux.esq != null)
                    pilha.push(aux.esq);
                momento = 2;
            } else if (momento == 2) {
                visita(aux);
                if (aux.dir != null)
                    pilha.push(aux.dir);
            }
        }
    }

    public void posOrdemNaoRecursiva(No p) {
        if (p == null)
            return;

        Stack<No> pilha = new Stack<>();
        pilha.push(p);
        int momento = 1;

        while (!pilha.empty()) {
            No aux = pilha.pop();

            if (momento == 1) {
                pilha.push(aux);
                if (aux.esq != null)
                    pilha.push(aux.esq);
                momento = 2;
            } else if (momento == 2) {
                pilha.push(aux);
                if (aux.dir != null)
                    pilha.push(aux.dir);
                momento = 3;
            } else if (momento == 3) {
                visita(aux);
            }
        }
    }
    // metodos de busca
    public No busca(int chave, No raiz, No[] pai, boolean[] encontrada) {
        if (raiz == null) {
            encontrada[0] = false;
            return null;
        } else if (raiz.chave == chave) {
            encontrada[0] = true;
            return raiz;
        } else if (chave < raiz.chave) {
            if (raiz.esq != null) {
                pai[0] = raiz;
                return busca(chave, raiz.esq, pai, encontrada);
            } else {
                encontrada[0] = false;
                return raiz;
            }
        } else {
            if (raiz.dir != null) {
                pai[0] = raiz;
                return busca(chave, raiz.dir, pai, encontrada);
            } else {
                encontrada[0] = false;
                return raiz;
            }
        }
    }
    //metodo de inserir dados na arvore
    public boolean inserir(int chave) {
        No pai = null;
        boolean[] encontrada = { false };
        No aux = busca(chave, raiz, new No[]{pai}, encontrada);

        if (!encontrada[0]) {
            No novoNo = new No(chave);
            novoNo.esq = null;
            novoNo.dir = null;

            if (aux == null) {
                raiz = novoNo;
            } else if (chave < aux.chave) {
                aux.esq = novoNo;
            } else {
                aux.dir = novoNo;
            }

            return true;
        } else {
            return false;
        }
    }
    // metodo remocao
    public boolean remover(int chave) {
        boolean[] encontrada = {false};
        No[] pai = new No[1];
        No no = busca(chave, raiz, pai, encontrada);

        if (no == null || !encontrada[0]) {
            return false; // Chave não encontrada
        }

        if (no.esq == null && no.dir == null) {
            if (pai[0] == null) {
                raiz = null; // Árvore vazia
            } else if (pai[0].esq == no) {
                pai[0].esq = null; // Remove nó folha à esquerda
            } else {
                pai[0].dir = null; // Remove nó folha à direita
            }
        } else if (no.esq == null || no.dir == null) {
            No filho = (no.esq != null) ? no.esq : no.dir;

            if (pai[0] == null) {
                raiz = filho; // Filho se torna a nova raiz
            } else if (pai[0].esq == no) {
                pai[0].esq = filho; // Substitui nó pelo filho à esquerda
            } else {
                pai[0].dir = filho; // Substitui nó pelo filho à direita
            }
        } else {
            No sucessor = encontrarSucessor(no.dir);
            No paiSucessor = encontrarPaiSucessor(no, sucessor);

            if (paiSucessor != no) {
                paiSucessor.esq = sucessor.dir; // Atualiza o filho à esquerda do pai do sucessor
                sucessor.dir = no.dir; // Conecta a subárvore à direita do nó removido ao sucessor
            }

            sucessor.esq = no.esq; // Conecta a subárvore à esquerda do nó removido ao sucessor

            if (pai[0] == null) {
                raiz = sucessor; // Sucessor se torna a nova raiz
            } else if (pai[0].esq == no) {
                pai[0].esq = sucessor; // Substitui nó pelo sucessor à esquerda
            } else {
                pai[0].dir = sucessor; // Substitui nó pelo sucessor à direita
            }
        }

        return true;
    }

    private No encontrarSucessor(No no) {
        while (no.esq != null) {
            no = no.esq;
        }
        return no;
    }

    private No encontrarPaiSucessor(No noRemovido, No sucessor) {
        No paiSucessor = null;
        No atual = noRemovido.dir;

        while (atual != sucessor) {
            paiSucessor = atual;
            atual = atual.esq;
        }

        return paiSucessor;
    }

}
