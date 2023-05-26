package ArvoreBinaria;

public class Arvore {
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

}
