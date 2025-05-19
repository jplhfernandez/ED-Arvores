package Ex_1;

class BinNo {
    int valor;
    BinNo esq, dir;
    Integer nivel; // Campo adicional para armazenar o nível

    public BinNo(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
        this.nivel = null;
    }
}

public class BArvore {
    private BinNo raiz;

    private BinNo inserir(BinNo atual, BinNo novoNo) {
        if (atual == null)
            return novoNo;
        else if (novoNo.valor < atual.valor)
            atual.esq = inserir(atual.esq, novoNo);
        else
            atual.dir = inserir(atual.dir, novoNo);
        return atual;
    }

    public void inserirNo(BinNo novoNo) {
        raiz = inserir(raiz, novoNo);
    }

    //Método para preencher os níveis usando DFS (pré-ordem)
    public void preencherNiveis() {
        preencherNiveis(raiz, 0);
    }

    private void preencherNiveis(BinNo no, int nivelAtual) {
        if (no == null) return;

        no.nivel = nivelAtual;

        preencherNiveis(no.esq, nivelAtual + 1);
        preencherNiveis(no.dir, nivelAtual + 1);
    }

    // Método para exibir os nós da árvore com seus níveis
    public void exibir() {
        System.out.println("Exibindo elementos da árvore:");
        exibirArvore(raiz);
    }

    private void exibirArvore(BinNo atual) {
        if (atual != null) {
            exibirArvore(atual.esq);
            System.out.println("Valor: " + atual.valor + " | Nível: " + atual.nivel);
            exibirArvore(atual.dir);
        }
    }

    // Método principal para testar
    public static void main(String[] args) {
        BArvore arvore = new BArvore();

        arvore.inserirNo(new BinNo(10));
        arvore.inserirNo(new BinNo(5));
        arvore.inserirNo(new BinNo(15));
        arvore.inserirNo(new BinNo(3));
        arvore.inserirNo(new BinNo(7));
        arvore.inserirNo(new BinNo(12));
        arvore.inserirNo(new BinNo(18));

        arvore.preencherNiveis();

        arvore.exibir();
    }
}
