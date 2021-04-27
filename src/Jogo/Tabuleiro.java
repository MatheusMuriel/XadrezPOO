package Jogo;

import java.util.ArrayList;
import java.util.Optional;

import Pecas.*;
import Utils.*;
import Pecas.Abstract.Peca;

public class Tabuleiro {
    private ArrayList<Peca> pecas;
    private static String[] colunas = {"A","B","C","D","E","F","G","H"};

    public Tabuleiro() {
        pecas = new ArrayList<>();

        for (NomePecas nomePeca : NomePecas.values()) {
            switch (nomePeca) {
                case PEAO:
                    for(int i = 0; i < 8; i++) this.adicionar(new Peao(nomePeca, Cores.BRANCO, "2", colunas[i]));
                    break;
                case TORRE:
                    for(int i = 0; i < 8; i+=7) this.adicionar(new Torre(nomePeca, Cores.BRANCO, "1", colunas[i]));
                    break;
                case CAVALO:
                    for(int i = 1; i < 7; i+=5) this.adicionar(new Cavalo(nomePeca, Cores.BRANCO, "1", colunas[i]));
                    break;
                case BISPO:
                    for(int i = 2; i < 6; i+=3) this.adicionar(new Bispo(nomePeca, Cores.BRANCO, "1", colunas[i]));
                    break;
                case REI:
                    this.adicionar(new Rei(nomePeca, Cores.BRANCO, "1", colunas[3]));
                    break;
                case RAINHA:
                    this.adicionar(new Rainha(nomePeca, Cores.BRANCO, "1", colunas[4]));
                    break;
            }
        }

        for (NomePecas nomePeca : NomePecas.values()) {
            switch (nomePeca) {
                case PEAO:
                    for(int i = 0; i < 8; i++) this.adicionar(new Peao(nomePeca, Cores.PRETO, "7", colunas[i]));
                    break;
                case TORRE:
                    for(int i = 0; i < 8; i+=7) this.adicionar(new Torre(nomePeca, Cores.PRETO, "8", colunas[i]));
                    break;
                case CAVALO:
                    for(int i = 1; i < 7; i+=5) this.adicionar(new Cavalo(nomePeca, Cores.PRETO, "8", colunas[i]));
                    break;
                case BISPO:
                    for(int i = 2; i < 6; i+=3) this.adicionar(new Bispo(nomePeca, Cores.PRETO, "8", colunas[i]));
                    break;
                case REI:
                    this.adicionar(new Rei(nomePeca, Cores.PRETO, "8", colunas[4]));
                    break;
                case RAINHA:
                    this.adicionar(new Rainha(nomePeca, Cores.PRETO, "8", colunas[3]));
                    break;
            }
        }
    }

    public void adicionar(Peca p) {
        pecas.add(p);
    }

    /** Remove a peça do jogo. */
    public void remover(Peca p) {

    }

    /**
     * Verifica se o movimento realizado obedece os limites físicos do tabuleiro.
     * @param posicao TODO verificar tipo
     * @return
     */
    public boolean isMovimentoValido(int posicao) {

        return false;
    }

    /** Verifica se o movimento eliminou a peça do adversário. */
    public boolean isMovimentoEliminatorio(Peca p, String posicao) {

        return false;
    }

    /** Imprime o status atual do jogo. Deve ser mostrado as posições atuais de cada peça. */
    public void imprimirConfiguracaoAtual() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("  a  b  c  d  e  f  g  h\n");
        for (int linha = 0; linha < 8; linha++) {
            strBuilder.append(8 - linha);
            for (int coluna = 0; coluna < 8; coluna++) {
                Optional<Peca> oPeca = existePecaNaPosicao(linha+1, coluna);
                if (oPeca.isPresent()) {
                    Peca p = oPeca.get();
                    strBuilder.append(" ");
                    strBuilder.append(p.getNome().getLetra(p.getNome(), p.getCor()));
                    strBuilder.append(" ");
                } else {
                    strBuilder.append(" . ");
                }

            }
            strBuilder.append(" ");
            strBuilder.append((8 - linha));
            strBuilder.append("\n");
        }
        strBuilder.append("  a  b  c  d  e  f  g  h\n");

        System.out.println(strBuilder.toString());
    }

    public Optional<Peca> existePecaNaPosicao(int linha, int colunaIndex) {
        Posicao posicao = new Posicao(colunas[colunaIndex], linha);
        Optional<Peca> pecaFiltrada;
        pecaFiltrada = pecas.stream()
                .filter(p -> p.getPosicaoAtual().equals(posicao))
                .findAny();

        return pecaFiltrada;
    }

}
