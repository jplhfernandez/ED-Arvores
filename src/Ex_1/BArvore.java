package Ex_1;

class BinNo {
    int valor;
    BinNo esq, dir;
    Integer nivel; // Campo adicional para armazenar o n�vel

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

    //M�todo para preencher os n�veis usando DFS (pr�-ordem)
    public void preencherNiveis() {
        preencherNiveis(raiz, 0);
    }

    private void preencherNiveis(BinNo no, int nivelAtual) {
        if (no == null) return;

        no.nivel = nivelAtual;

        preencherNiveis(no.esq, nivelAtual + 1);
        preencherNiveis(no.dir, nivelAtual + 1);
    }

    // M�todo para exibir os n�s da �rvore com seus n�veis
    public void exibir() {
        System.out.println("Exibindo elementos da �rvore:");
        exibirArvore(raiz);
    }

    private void exibirArvore(BinNo atual) {
        if (atual != null) {
            exibirArvore(atual.esq);
            System.out.println("Valor: " + atual.valor + " | N�vel: " + atual.nivel);
            exibirArvore(atual.dir);
        }
    }

    // M�todo principal para testar
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
