package Jogo;

import Pecas.Abstract.Peca;
import Utils.Cores;
import Utils.NomePecas;
import Utils.Posicao;
import Utils.StatusJogo;

import java.util.ArrayList;
import java.util.Optional;

public class Xadrez {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorDaVez;

    public Xadrez(Tabuleiro t, Jogador j1, Jogador j2) {
        this.tabuleiro = t;
        this.jogador1 = j1;
        this.jogador2 = j2;
        this.jogadorDaVez = this.jogador1;
    }

    public void jogar(Posicao[] posicoes) {
        Peca pecaOrigem = this.tabuleiro.existePecaNaPosicao(
                posicoes[0].getColuna(), posicoes[0].getLinha()).get();

        boolean existeCaptura = this.tabuleiro.isMovimentoEliminatorio(pecaOrigem, posicoes[1]);
        if (existeCaptura) {
            Peca pecaDestino = this.tabuleiro.existePecaNaPosicao(
                    posicoes[1].getColuna(), posicoes[1].getLinha()).get();
            this.tabuleiro.remover(pecaDestino);
            System.out.println("A peça " + pecaDestino.getNome() + " de " + pecaDestino.getPosicaoAtual() + " da cor " + pecaDestino.getCor() + " foi capturada!");
            this.jogadorDaVez.adicionarPecaCapturada(pecaDestino);
        }

        pecaOrigem.atualizarPosicao(posicoes[1]);
        this.jogadorDaVez = this.jogadorDaVez == this.jogador1 ? this.jogador2 : this.jogador1;
    }

    public boolean isMovimentoValido(Posicao[] posicoes) {
        boolean tabuleiroValidade = this.tabuleiro.isMovimentoValido(posicoes[1]);
        if (tabuleiroValidade) {
            Optional<Peca> opPecaOrigem = this.tabuleiro.existePecaNaPosicao(
                    posicoes[0].getColuna(), posicoes[0].getLinha());
            if (opPecaOrigem.isPresent()) {
                Peca pecaOrigem = opPecaOrigem.get();
                boolean pecaValida = pecaOrigem.getCor().equals(this.jogadorDaVez.getCorPeca());
                if (pecaValida)  {
                    boolean movimentoValido = pecaOrigem.isMovimentoValido(posicoes[1], this.tabuleiro);
                    if (movimentoValido) {
                        return true;
                    } else {
                        System.out.println("Movimento de peça invalido.");
                        return false;
                    }
                } else {
                    System.out.println("Essa peça não é sua.");
                    return false;
                }
            } else {
                System.out.println("Não existe uma peça nesta posição.");
                return false;
            }
        } else {
            System.out.println("Esse Movimentro ultrapassa os limites do tabuleiro.");
            return false;
        }
    }

    public StatusJogo getStatusDoJogo() {
        ArrayList<Peca> pecas = this.tabuleiro.getPecas();
        StatusJogo status = StatusJogo.EM_JOGO;

        Optional<Peca> reiBranco = pecas
                .stream()
                .filter(p -> p.getNome().equals(NomePecas.REI) && p.getCor().equals(Cores.BRANCO))
                .findAny();

        Optional<Peca> reiPreto = pecas
                .stream()
                .filter(p -> p.getNome().equals(NomePecas.REI) && p.getCor().equals(Cores.PRETO))
                .findAny();

        if (reiBranco.isPresent() && !reiPreto.isPresent()) status = StatusJogo.JOGADOR1_VENCEU;
        if (!reiBranco.isPresent() && reiPreto.isPresent()) status = StatusJogo.JOGADOR2_VENCEU;

        return status;
    }

    public void imprimir() {
        System.out.println("---------------------------");
        System.out.println("Jogador: " + jogadorDaVez.getNome());
        System.out.println("Cor: " + jogadorDaVez.getCorPeca());
        System.out.println("---------------------------");
        this.tabuleiro.imprimirConfiguracaoAtual();
    }

}
