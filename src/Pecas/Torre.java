package Pecas;

import Pecas.Abstract.Peca;
import Utils.Cores;
import Utils.NomePecas;
import Utils.Posicao;

public class Torre extends Peca {

    public Torre(NomePecas nome, Cores cor, int linha, String coluna) {
        super(nome, cor, linha, coluna);
    }

    @Override
    public void atualizarPosicao(Posicao posicao) {

    }

    @Override
    public boolean isMovimentoValido(Posicao posicao) {
        // TODO implementar Rogue
        return false;
    }
}
