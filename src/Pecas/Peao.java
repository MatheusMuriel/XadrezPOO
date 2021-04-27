package Pecas;

import Pecas.Abstract.Peca;
import Utils.Cores;
import Utils.NomePecas;
import Utils.Posicao;

public class Peao extends Peca {

    public Peao(NomePecas nome, Cores cor, int linha, String coluna) {
        super(nome, cor, linha, coluna);
    }

    @Override
    public void atualizarPosicao(Posicao posicao) {
        super.setPosicaoAtual(posicao);
    }

    @Override
    public boolean isMovimentoValido(Posicao posicao) {
        // TODO implementar logica de só capturar de lado
        return true;
    }

    @Override
    public boolean capturaEm(Posicao posicao) {
        return false;
    }
}
