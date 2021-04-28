package Pecas.Abstract;

import Jogo.Tabuleiro;
import Utils.*;

public abstract class Peca {
    NomePecas nome;
    Cores cor;
    Posicao posicaoAtual;

    public Peca (NomePecas nome, Cores cor, int linha, String coluna) {
        Posicao posicao = new Posicao(coluna, linha);
        setPosicaoAtual(posicao);
        setNome(nome);
        setCor(cor);
    }

    public abstract void atualizarPosicao(Posicao posicao);

    public abstract boolean isMovimentoValido(Posicao posicao, Tabuleiro tabuleiro);

    public abstract boolean capturaEm(Posicao posicao, Tabuleiro tabuleiro);


    /********** Getters e Setters **********/
    public NomePecas getNome() {
        return nome;
    }
    public void setNome(NomePecas nome) {
        this.nome = nome;
    }
    public Cores getCor() {
        return cor;
    }
    public void setCor(Cores cor) {
        this.cor = cor;
    }
    public Posicao getPosicaoAtual() {
        return posicaoAtual;
    }
    public void setPosicaoAtual(Posicao posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }
}
