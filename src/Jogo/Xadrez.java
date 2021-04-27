package Jogo;

import Pecas.Abstract.Peca;
import Utils.NomePecas;
import Utils.Posicao;
import Utils.StatusJogo;

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

    public void jogar(Jogador jogador, NomePecas nomePeca, Posicao posicao) {

    }

    public boolean isMovimentoValido(Posicao[] posicoes) {
        boolean tabuleiroValidade = this.tabuleiro.isMovimentoValido(posicoes[1]);
        if (tabuleiroValidade) {
            Optional<Peca> opPecaOrigem = this.tabuleiro.existePecaNaPosicao(
                    posicoes[0].getColuna(), posicoes[0].getLinha());
            if (opPecaOrigem.isPresent()) {
                Peca pecaOrigem = opPecaOrigem.get();
                boolean pecaValidade = pecaOrigem.isMovimentoValido(posicoes[1]);
                if (pecaValidade)  {
                    return true;
                } else {
                    System.out.println("Movimento de peça invalido.");
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
        // TODO implementar Logica
        return StatusJogo.EM_JOGO;
    }

    public void imprimir() {
        System.out.println("---------------------------");
        System.out.println("Jogador: " + jogadorDaVez.getNome());
        System.out.println("Cor: " + jogadorDaVez.getCorPeca());
        System.out.println("---------------------------");
        this.tabuleiro.imprimirConfiguracaoAtual();
    }

}
