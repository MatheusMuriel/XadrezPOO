package Pecas;

import Jogo.Tabuleiro;
import Pecas.Abstract.Peca;
import Utils.Cores;
import Utils.NomePecas;
import Utils.Posicao;

import java.util.ArrayList;
import java.util.Optional;

public class Peao extends Peca {
    private boolean usouAvancoDuplo;
    public Peao(NomePecas nome, Cores cor, int linha, String coluna) {
        super(nome, cor, linha, coluna);
        this.usouAvancoDuplo = false;
    }

    @Override
    public void atualizarPosicao(Posicao posicao) {
        super.setPosicaoAtual(posicao);
        this.usouAvancoDuplo = true;
    }

    @Override
    public boolean isMovimentoValido(Posicao posicao, Tabuleiro tabuleiro) {
        Posicao posicaoAtual = super.getPosicaoAtual();
        ArrayList<Posicao> movimentosValidos = new ArrayList<>();
        if (super.getCor().equals(Cores.BRANCO)) {
            Posicao p_temp = new Posicao(posicaoAtual.getColuna(), getPosicaoAtual().getLinha()+1);
            if (!tabuleiro.existePecaNaPosicao(p_temp.getColuna(), p_temp.getLinha()).isPresent()) {
                movimentosValidos.add(new Posicao(posicaoAtual.getColuna(), getPosicaoAtual().getLinha()+1));
            }
        } else {
            Posicao p_temp = new Posicao(posicaoAtual.getColuna(), getPosicaoAtual().getLinha()-1);
            if (!tabuleiro.existePecaNaPosicao(p_temp.getColuna(), p_temp.getLinha()).isPresent()) {
                movimentosValidos.add(p_temp);
            }
        }
        if (!this.usouAvancoDuplo) {
            if (super.getCor().equals(Cores.BRANCO)) {
                Posicao p_temp = new Posicao(posicaoAtual.getColuna(), getPosicaoAtual().getLinha()+2);
                if (!tabuleiro.existePecaNaPosicao(p_temp.getColuna(), p_temp.getLinha()).isPresent()) {
                    movimentosValidos.add(p_temp);
                }
            } else {
                Posicao p_temp = new Posicao(posicaoAtual.getColuna(), getPosicaoAtual().getLinha()-2);
                if (!tabuleiro.existePecaNaPosicao(p_temp.getColuna(), p_temp.getLinha()).isPresent()) {
                    movimentosValidos.add(p_temp);
                }
            }
        }
        boolean jogadaValida = movimentosValidos.stream().anyMatch(p -> p.equalsTo(posicao));
        return jogadaValida || capturaEm(posicao, tabuleiro);
    }

    @Override
    public boolean capturaEm(Posicao posicao, Tabuleiro tabuleiro) {
        ArrayList<Posicao> movimentosValidos = new ArrayList<>();
        ArrayList<String> colunas = tabuleiro.getColunas();
        int indexColuna = colunas.indexOf(super.getPosicaoAtual().getColuna());
        if (super.getCor().equals(Cores.BRANCO)) {
            movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna+1), getPosicaoAtual().getLinha()+1));
            movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna-1), getPosicaoAtual().getLinha()+1));
        } else {
            movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna+1), getPosicaoAtual().getLinha()-1));
            movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna-1), getPosicaoAtual().getLinha()-1));
        }

        return movimentosValidos.stream().anyMatch(p -> {
            Optional<Peca> opPeca = tabuleiro.existePecaNaPosicao(p.getColuna(), p.getLinha());
            return opPeca.filter(peca -> p.equalsTo(posicao) && !peca.getCor().equals(super.getCor())).isPresent();
        });
    }
}
