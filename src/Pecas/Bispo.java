package Pecas;

import Jogo.Tabuleiro;
import Pecas.Abstract.Peca;
import Utils.Cores;
import Utils.NomePecas;
import Utils.Posicao;

import java.util.ArrayList;

public class Bispo extends Peca {

    public Bispo(NomePecas nome, Cores cor, int linha, String coluna) {
        super(nome, cor, linha, coluna);
    }

    @Override
    public void atualizarPosicao(Posicao posicao) {
        super.setPosicaoAtual(posicao);
    }

    @Override
    public boolean isMovimentoValido(Posicao posicao, Tabuleiro tabuleiro) {
        Posicao posicaoAtual = super.getPosicaoAtual();
        int indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());
        ArrayList<Posicao> movimentosValidos = new ArrayList<>();
        movimentosValidos.add(
                new Posicao(tabuleiro.getColunas().get(indexColuna+1),
                            getPosicaoAtual().getLinha()+1)
        );

        if (super.getCor().equals(Cores.BRANCO)) {
            movimentosValidos.add(new Posicao(posicaoAtual.getColuna(), getPosicaoAtual().getLinha()+1));
        } else {
            movimentosValidos.add(new Posicao(posicaoAtual.getColuna(), getPosicaoAtual().getLinha()-1));
        }

        boolean jogadaValida = movimentosValidos.stream().anyMatch(p -> p.equalsTo(posicao));

        return jogadaValida || capturaEm(posicao, tabuleiro);
    }

    @Override
    public boolean capturaEm(Posicao posicao, Tabuleiro tabuleiro) {
        return false;
    }
}
