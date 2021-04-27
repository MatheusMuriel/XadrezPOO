package Pecas.Abstract;

import Utils.Cores;
import Utils.NomePecas;

public abstract class Peca {
    NomePecas nome;
    Cores cor;
    double posicaoAtual;

    /** Construtor que recebe um nome, uma cor e uma posição inicial. */
    public Peca (String nome, String cor, String posicao) {

    }

    public void atualizarPosicao(String posicao) {

    }

    /** Método abstrato para verificar se a posição solicitada
     * é válida dado as regras de movimentação daquela peça.
     * */
    public abstract boolean isMovimentoValido(String posicao);

}
