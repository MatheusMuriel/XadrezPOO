package Pecas;

import Jogo.Tabuleiro;
import Pecas.Abstract.Peca;
import Utils.Cores;
import Utils.NomePecas;
import Utils.Posicao;

public class Rei extends Peca {

    public Rei(NomePecas nome, Cores cor, int linha, String coluna) {
        super(nome, cor, linha, coluna);
    }

    @Override
    public void atualizarPosicao(Posicao posicao) {

    }

    @Override
    public boolean isMovimentoValido(Posicao posicao, Tabuleiro tabuleiro) {
        // TODO implementar Rogue
        return false;
    }

    @Override
    public boolean capturaEm(Posicao posicao, Tabuleiro tabuleiro) {
        return false;
    }
}
