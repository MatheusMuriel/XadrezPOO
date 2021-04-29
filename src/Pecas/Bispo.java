package Pecas;

import Jogo.Tabuleiro;
import Pecas.Abstract.Peca;
import Utils.Cores;
import Utils.NomePecas;
import Utils.Posicao;

import java.util.ArrayList;
import java.util.Optional;

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

        int linha = posicaoAtual.getLinha();
        int indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());

        ArrayList<Posicao> movimentosValidos = new ArrayList<>();

        boolean d1 = true;
        while (d1) {
            linha += 1;
            indexColuna += 1;
            if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
                Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
                if(!tabuleiro.isMovimentoValido(p1)) break;
                Optional<Peca> opPeca = tabuleiro.existePecaNaPosicao(tabuleiro.getColunas().get(indexColuna), linha);
                if (!opPeca.isPresent()) {
                    movimentosValidos.add(p1);
                }
                if (opPeca.isPresent() && !opPeca.get().getCor().equals(this.getCor())) {
                    movimentosValidos.add(p1);
                }
                d1 = !opPeca.isPresent() && indexColuna < 7;
            } else {
                d1 = false;
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());

        boolean d2 = true;
        while (d2) {
            linha += 1;
            indexColuna -= 1;
            if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
                Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
                if(!tabuleiro.isMovimentoValido(p1)) break;
                Optional<Peca> opPeca = tabuleiro.existePecaNaPosicao(tabuleiro.getColunas().get(indexColuna), linha);
                if (!opPeca.isPresent()) {
                    movimentosValidos.add(p1);
                }
                if (opPeca.isPresent() && !opPeca.get().getCor().equals(this.getCor())) {
                    movimentosValidos.add(p1);
                }
                d2 = !opPeca.isPresent() && indexColuna > 0;
            } else {
                d2 = false;
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());

        boolean d3 = true;
        while (d3) {
            linha -= 1;
            indexColuna += 1;
            if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
                Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
                if(!tabuleiro.isMovimentoValido(p1)) break;
                Optional<Peca> opPeca = tabuleiro.existePecaNaPosicao(tabuleiro.getColunas().get(indexColuna), linha);
                if (!opPeca.isPresent()) {
                    movimentosValidos.add(p1);
                }
                if (opPeca.isPresent() && !opPeca.get().getCor().equals(this.getCor())) {
                    movimentosValidos.add(p1);
                }
                d3 = !opPeca.isPresent() && indexColuna < 7;
            } else {
                d3 = false;
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());

        boolean d4 = true;
        while (d4) {
            linha -= 1;
            indexColuna -= 1;
            if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
                Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
                if(!tabuleiro.isMovimentoValido(p1)) break;
                Optional<Peca> opPeca = tabuleiro.existePecaNaPosicao(tabuleiro.getColunas().get(indexColuna), linha);
                if (!opPeca.isPresent()) {
                    movimentosValidos.add(p1);
                }
                if (opPeca.isPresent() && !opPeca.get().getCor().equals(this.getCor())) {
                    movimentosValidos.add(p1);
                }
                d4 = !opPeca.isPresent() && indexColuna > 0;
            } else {
                d4 = false;
            }
        }


        boolean jogadaValida = movimentosValidos.stream().anyMatch(p -> p.equalsTo(posicao));

        return jogadaValida || capturaEm(posicao, tabuleiro);
    }

    @Override
    public boolean capturaEm(Posicao posicao, Tabuleiro tabuleiro) {
        return false;
    }
}
