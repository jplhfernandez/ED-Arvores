package Ex_ED_0519;

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
        //Contempla o EX_2
        System.out.println("EX - 2 - Quantidade de elementos na �rvore: " + arvore.contarElementos());

        arvore.inserirNo(new BinNo(10));
        arvore.inserirNo(new BinNo(5));
        arvore.inserirNo(new BinNo(15));
        arvore.inserirNo(new BinNo(3));
        arvore.inserirNo(new BinNo(7));
        arvore.inserirNo(new BinNo(12));
        arvore.inserirNo(new BinNo(18));

        arvore.preencherNiveis();

        arvore.exibir();
        //Contempla o EX_3
        arvore.encontrarCaminho(7);  
        //Contempla o EX_2
        System.out.println("EX - 2 - Quantidade de elementos na �rvore: " + arvore.contarElementos());
        //Contempla o Ex_4
        arvore.exibirFolhasEmOrdem();
    }
 
 //Contempla o EX_2
 // Conta todos os n�s da �rvore
    public int contarElementos() {
        return contarElementos(raiz);
    }

    private int contarElementos(BinNo no) {
        if (no == null) return 0;
        return 1 + contarElementos(no.esq) + contarElementos(no.dir);
    }

  //Contempla o EX_3
  //Encontra e imprime o caminho da raiz at� o valor desejado
  public boolean encontrarCaminho(int valor) {
   System.out.println("EX - 3 - Antecessores (at� a raiz) do valor " + valor + ":");
   boolean encontrado = encontrarCaminho(raiz, valor);
   if (!encontrado) {
       System.out.println("EX - 3 - Valor n�o encontrado na �rvore.");
   }
   return encontrado;
  }

  private boolean encontrarCaminho(BinNo atual, int valor) {
   if (atual == null) return false;

   // Se encontrou o valor
   if (atual.valor == valor) {
       System.out.println(atual.valor);
       return true;
   }

   // Se valor estiver � esquerda ou � direita
   if (encontrarCaminho(atual.esq, valor) || encontrarCaminho(atual.dir, valor)) {
       System.out.println(atual.valor); // Imprime o antecessor
       return true;
   }

   return false;
  }
  
  
  	//Xontempla o EX_4
	//Exibe as folhas da �rvore em ordem crescente
	public void exibirFolhasEmOrdem() {
	   System.out.println("EX - 4 - Folhas da �rvore em ordem crescente:");
	   exibirFolhasEmOrdem(raiz);
	}
	
	private void exibirFolhasEmOrdem(BinNo no) {
	   if (no == null) return;
	
	   exibirFolhasEmOrdem(no.esq); // Visita esquerda
	
	   // Verifica se � folha
	   if (no.esq == null && no.dir == null) {
	       System.out.println(no.valor);
	   }
	
	   exibirFolhasEmOrdem(no.dir); // Visita direita
	}
}



