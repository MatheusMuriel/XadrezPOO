package Jogo;

import java.util.ArrayList;
import Pecas.Abstract.Peca;

public class Tabuleiro {
    private ArrayList<Peca> pecas;

    public void adicionar(Peca p) {

    }

    /**
     * Verifica se o movimento realizado obedece os limites físicos do tabuleiro.
     * @param posicao TODO verificar tipo
     * @return
     */
    public boolean isMovimentoValido(int posicao) {

        return false;
    }

    /** Imprime o status atual do jogo. Deve ser mostrado as posições atuais de cada peça. */
    public void imprimirConfiguracaoAtual() {

    }

    /** Verifica se o movimento eliminou a peça do adversário. */
    public boolean isMovimentoEliminatorio(Peca p, String posicao) {

        return false;
    }

    /** Remove a peça do jogo. */
    public void remover(Peca p) {

    }

}
