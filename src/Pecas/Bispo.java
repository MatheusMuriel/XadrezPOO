package Pecas;

import Pecas.Abstract.Peca;
import Utils.Cores;
import Utils.NomePecas;

public class Bispo extends Peca {
    /**
     * Construtor que recebe um nome, uma cor e uma posição inicial.
     *
     * @param nome
     * @param cor
     * @param linha
     * @param coluna
     */
    public Bispo(NomePecas nome, Cores cor, int linha, String coluna) {
        super(nome, cor, linha, coluna);
    }

    @Override
    public void atualizarPosicao(String posicao) {

    }

    @Override
    public boolean isMovimentoValido(String posicao) {
        return false;
    }
}
