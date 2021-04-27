package Jogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import Pecas.*;
import Utils.*;
import Pecas.Abstract.Peca;

public class Tabuleiro {
    private ArrayList<Peca> pecas;
    private ArrayList<String> colunas;


    public Tabuleiro() {
        String[] letras = {"A","B","C","D","E","F","G","H"};
        this.colunas = new ArrayList<>(Arrays.asList(letras));
        pecas = new ArrayList<>();

        for (NomePecas nomePeca : NomePecas.values()) {
            switch (nomePeca) {
                case PEAO:
                    for(int i = 0; i < 8; i++) this.adicionar(new Peao(nomePeca, Cores.BRANCO, 2, this.colunas.get(i)));
                    break;
                case TORRE:
                    for(int i = 0; i < 8; i+=7) this.adicionar(new Torre(nomePeca, Cores.BRANCO, 1, this.colunas.get(i)));
                    break;
                case CAVALO:
                    for(int i = 1; i < 7; i+=5) this.adicionar(new Cavalo(nomePeca, Cores.BRANCO, 1, this.colunas.get(i)));
                    break;
                case BISPO:
                    for(int i = 2; i < 6; i+=3) this.adicionar(new Bispo(nomePeca, Cores.BRANCO, 1, this.colunas.get(i)));
                    break;
                case REI:
                    this.adicionar(new Rei(nomePeca, Cores.BRANCO, 1, this.colunas.get(4)));
                    break;
                case RAINHA:
                    this.adicionar(new Rainha(nomePeca, Cores.BRANCO, 1, this.colunas.get(3)));
                    break;
            }
        }

        for (NomePecas nomePeca : NomePecas.values()) {
            switch (nomePeca) {
                case PEAO:
                    for(int i = 0; i < 8; i++) this.adicionar(new Peao(nomePeca, Cores.PRETO, 7, this.colunas.get(i)));
                    break;
                case TORRE:
                    for(int i = 0; i < 8; i+=7) this.adicionar(new Torre(nomePeca, Cores.PRETO, 8, this.colunas.get(i)));
                    break;
                case CAVALO:
                    for(int i = 1; i < 7; i+=5) this.adicionar(new Cavalo(nomePeca, Cores.PRETO, 8, this.colunas.get(i)));
                    break;
                case BISPO:
                    for(int i = 2; i < 6; i+=3) this.adicionar(new Bispo(nomePeca, Cores.PRETO, 8, this.colunas.get(i)));
                    break;
                case REI:
                    this.adicionar(new Rei(nomePeca, Cores.PRETO, 8, this.colunas.get(4)));
                    break;
                case RAINHA:
                    this.adicionar(new Rainha(nomePeca, Cores.PRETO, 8, this.colunas.get(3)));
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

    /** Verifica se o movimento realizado obedece os limites físicos do tabuleiro. */
    public boolean isMovimentoValido(Posicao posicaoDestino) {
        int l = posicaoDestino.getLinha();
        String c = posicaoDestino.getColuna();
        boolean linhaValida = (l > 0 && l < 9);
        boolean colunaValida = this.colunas.contains(c.toUpperCase());
        return linhaValida && colunaValida;
    }

    /** Verifica se o movimento eliminou a peça do adversário. */
    public boolean isMovimentoEliminatorio(Peca p, String posicao) {

        return false;
    }

    /** Imprime o status atual do jogo. Deve ser mostrado as posições atuais de cada peça. */
    public void imprimirConfiguracaoAtual() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("  a  b  c  d  e  f  g  h\n");
        for (int linha = 7; linha >= 0; linha--) {
            strBuilder.append(linha+1);
            for (int coluna = 0; coluna < 8; coluna++) {
                Optional<Peca> oPeca = existePecaNaPosicao(this.colunas.get(coluna), linha+1);
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

    public Optional<Peca> existePecaNaPosicao(String coluna, int linha) {
        Posicao posicao = new Posicao(coluna, linha);
        Optional<Peca> pecaFiltrada;
        pecaFiltrada = pecas.stream()
                .filter(p -> p.getPosicaoAtual().equalsTo(posicao))
                .findAny();

        return pecaFiltrada;
    }

}
