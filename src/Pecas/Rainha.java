package Pecas;

import Pecas.Abstract.Peca;
import Utils.Cores;
import Utils.NomePecas;
import Utils.Posicao;

public class Rainha extends Peca {

    /**
     * Construtor que recebe um nome, uma cor e uma posição inicial.
     *
     * @param nome
     * @param cor
     * @param linha
     * @param coluna
     */
    public Rainha(NomePecas nome, Cores cor, int linha, String coluna) {
        super(nome, cor, linha, coluna);
    }

    @Override
    public void atualizarPosicao(Posicao posicao) {

    }

    @Override
    public boolean isMovimentoValido(Posicao posicao) {
        return false;
    }
}
