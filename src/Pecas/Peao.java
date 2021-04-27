package Pecas;

import Pecas.Abstract.Peca;
import Utils.Cores;
import Utils.NomePecas;

public class Peao extends Peca {

    /**
     * Construtor que recebe um nome, uma cor e uma posição inicial.
     *
     * @param nome
     * @param cor
     * @param linha
     * @param coluna
     */
    public Peao(NomePecas nome, Cores cor, String linha, String coluna) {
        super(nome, cor, linha, coluna);
    }

    @Override
    public boolean isMovimentoValido(String posicao) {
        return false;
    }
}
