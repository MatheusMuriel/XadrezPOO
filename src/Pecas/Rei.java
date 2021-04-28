package Pecas;

import Jogo.Tabuleiro;
import Pecas.Abstract.Peca;
import Utils.Cores;
import Utils.NomePecas;
import Utils.Posicao;

import java.util.ArrayList;
import java.util.Optional;

public class Rei extends Peca {

    public Rei(NomePecas nome, Cores cor, int linha, String coluna) {
        super(nome, cor, linha, coluna);
    }

    @Override
    public void atualizarPosicao(Posicao posicao) {
        super.setPosicaoAtual(posicao);
    }

    @Override
    public boolean isMovimentoValido(Posicao posicao, Tabuleiro tabuleiro) {
        Posicao posicaoAtual = super.getPosicaoAtual();
        ArrayList<String> colunas = tabuleiro.getColunas();
        int indexColuna = colunas.indexOf(super.getPosicaoAtual().getColuna());
        ArrayList<Posicao> movimentosValidos = new ArrayList<>();
        movimentosValidos.add(new Posicao(posicaoAtual.getColuna(), getPosicaoAtual().getLinha()+1));
        movimentosValidos.add(new Posicao(posicaoAtual.getColuna(), getPosicaoAtual().getLinha()-1));
        movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna+1), getPosicaoAtual().getLinha()));
        movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna-1), getPosicaoAtual().getLinha()));
        movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna+1), getPosicaoAtual().getLinha()+1));
        movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna+1), getPosicaoAtual().getLinha()-1));
        movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna-1), getPosicaoAtual().getLinha()+1));
        movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna-1), getPosicaoAtual().getLinha()-1));
        return movimentosValidos.stream().anyMatch(p -> p.equalsTo(posicao));
        // TODO implementar Rogue
    }

    @Override
    public boolean capturaEm(Posicao posicao, Tabuleiro tabuleiro) {
        Posicao posicaoAtual = super.getPosicaoAtual();
        ArrayList<String> colunas = tabuleiro.getColunas();
        int indexColuna = colunas.indexOf(super.getPosicaoAtual().getColuna());
        ArrayList<Posicao> movimentosValidos = new ArrayList<>();
        movimentosValidos.add(new Posicao(posicaoAtual.getColuna(), getPosicaoAtual().getLinha()+1));
        movimentosValidos.add(new Posicao(posicaoAtual.getColuna(), getPosicaoAtual().getLinha()-1));
        movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna+1), getPosicaoAtual().getLinha()));
        movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna-1), getPosicaoAtual().getLinha()));
        movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna+1), getPosicaoAtual().getLinha()+1));
        movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna+1), getPosicaoAtual().getLinha()-1));
        movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna-1), getPosicaoAtual().getLinha()+1));
        movimentosValidos.add(new Posicao(tabuleiro.getColunas().get(indexColuna-1), getPosicaoAtual().getLinha()-1));
        return movimentosValidos.stream().anyMatch(p -> {
            Optional<Peca> opPeca = tabuleiro.existePecaNaPosicao(p.getColuna(), p.getLinha());
            return opPeca.filter(peca -> p.equalsTo(posicao) && !peca.getCor().equals(super.getCor())).isPresent();
        });

        //return isMovimentoValido(posicao, tabuleiro);
    }
}
