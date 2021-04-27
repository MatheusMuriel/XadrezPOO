package Pecas.Abstract;

import Utils.Cores;
import Utils.NomePecas;

public abstract class Peca {
    NomePecas nome;
    Cores cor;

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

    public String[] getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(String[] posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    String[] posicaoAtual;

    /** Construtor que recebe um nome, uma cor e uma posição inicial. */
    public Peca (NomePecas nome, Cores cor, String linha, String coluna) {
        String[] posicao = {linha, coluna};
        setPosicaoAtual(posicao);
        setNome(nome);
        setCor(cor);
    }

    public void atualizarPosicao(String posicao) {

    }

    /** Método abstrato para verificar se a posição solicitada
     * é válida dado as regras de movimentação daquela peça.
     * */
    public abstract boolean isMovimentoValido(String posicao);

}
