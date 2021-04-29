package Pecas;

import Jogo.Tabuleiro;
import Pecas.Abstract.Peca;
import Utils.Cores;
import Utils.NomePecas;
import Utils.Posicao;

public class Cavalo extends Peca {

    public Cavalo(NomePecas nome, Cores cor, int linha, String coluna) {
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

        // M1
        linha += 1;
        indexColuna -= 2;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());


        // M2
        linha += 2;
        indexColuna -= 1;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());


        // M3
        linha += 2;
        indexColuna += 1;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());


        // M4
        linha += 1;
        indexColuna += 2;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());
        
        // M5
        linha -= 1;
        indexColuna += 2;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());


        // M6
        linha -= 2;
        indexColuna += 1;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());


        // M7
        linha -= 2;
        indexColuna -= 1;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());


        // M8
        linha -= 1;
        indexColuna -= 2;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }

        boolean jogadaValida = movimentosValidos.stream().anyMatch(p -> p.equalsTo(posicao));

        return jogadaValida || capturaEm(posicao, tabuleiro);
    }

    @Override
    public boolean capturaEm(Posicao posicao, Tabuleiro tabuleiro) {
        Posicao posicaoAtual = super.getPosicaoAtual();

        int linha = posicaoAtual.getLinha();
        int indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());

        ArrayList<Posicao> movimentosValidos = new ArrayList<>();

        // M1
        linha += 1;
        indexColuna -= 2;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());


        // M2
        linha += 2;
        indexColuna -= 1;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());


        // M3
        linha += 2;
        indexColuna += 1;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());


        // M4
        linha += 1;
        indexColuna += 2;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());
        
        // M5
        linha -= 1;
        indexColuna += 2;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());


        // M6
        linha -= 2;
        indexColuna += 1;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());


        // M7
        linha -= 2;
        indexColuna -= 1;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }
        linha = posicaoAtual.getLinha();
        indexColuna = tabuleiro.getColunas().indexOf(super.getPosicaoAtual().getColuna());


        // M8
        linha -= 1;
        indexColuna -= 2;
        if(indexColuna < tabuleiro.getColunas().size() && indexColuna >= 0) {
            Posicao p1 = new Posicao(tabuleiro.getColunas().get(indexColuna), linha);
            if(tabuleiro.isMovimentoValido(p1)) {
                movimentosValidos.add(p1);
            }
        }

        return movimentosValidos.stream().anyMatch(p -> {
            Optional<Peca> opPeca = tabuleiro.existePecaNaPosicao(p.getColuna(), p.getLinha());
            return opPeca.filter(peca -> p.equalsTo(posicao) && !peca.getCor().equals(super.getCor())).isPresent();
        });
    }
}
