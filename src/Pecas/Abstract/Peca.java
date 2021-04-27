package Pecas.Abstract;

import Utils.*;

public abstract class Peca {
    NomePecas nome;
    Cores cor;
    Posicao posicaoAtual;

    /** Construtor que recebe um nome, uma cor e uma posição inicial. */
    public Peca (NomePecas nome, Cores cor, int linha, String coluna) {
        Posicao posicao = new Posicao(coluna, linha);
        setPosicaoAtual(posicao);
        setNome(nome);
        setCor(cor);
    }

    public abstract void atualizarPosicao(Posicao posicao);

    /** Método abstrato para verificar se a posição solicitada é válida dado as regras de movimentação daquela peça. **/
    public abstract boolean isMovimentoValido(Posicao posicao);


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
