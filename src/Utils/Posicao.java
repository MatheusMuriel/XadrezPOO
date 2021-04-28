package Utils;

import Pecas.Abstract.Peca;

import java.util.Locale;

public class Posicao {
    private String coluna;
    private int linha;

    public Posicao(String coluna, int linha) {
        this.coluna = coluna;
        this.linha = linha;
    }

    public Posicao(String posicao) {
        String[] posicoes = posicao.split("");
        this.coluna = posicoes[0];
        this.linha = Integer.parseInt(posicoes[1]);
    }

    public String toString() {
        return coluna + linha;
    }

    public boolean equalsTo(Posicao p2) {
        return (p2.coluna.toUpperCase().equals(this.coluna.toUpperCase()) && p2.linha == this.linha);
    }

    public String getColuna() {
        return coluna.toUpperCase();
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
