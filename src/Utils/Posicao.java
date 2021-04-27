package Utils;

import Pecas.Abstract.Peca;

public class Posicao {
    private String coluna;
    private int linha;

    public Posicao(String coluna, int linha) {
        this.coluna = coluna;
        this.linha = linha;
    }

    public String toString() {
        return coluna + linha;
    }

    public boolean equalsTo(Posicao p2) {
        return (p2.coluna.equals(this.coluna) && p2.linha == this.linha);
    }

    public String getColuna() {
        return coluna;
    }

    public void setColuna(String coluna) {
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }
}
