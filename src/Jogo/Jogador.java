package Jogo;

import java.util.ArrayList;
import Pecas.Abstract.Peca;
import Utils.Cores;

public class Jogador {
    String nome;
    Cores corPeca;
    double pontuacao;
    ArrayList<Peca> pecasCapturadas;

    /** Construtor que recebe um nome e uma cor de peça. */
    public Jogador(String nome, Cores corPeca) {
        this.nome = nome;
        this.corPeca = corPeca;
        this.pontuacao = 0;
        this.pecasCapturadas = new ArrayList<>();
    }

    public void adicionarPecaCapturada(Peca pecaCapturada) {
        this.pecasCapturadas.add(pecaCapturada);
    }

    /** Getters e Setters **/
    public String getNome() {
        return nome;
    }

    public Cores getCorPeca() {
        return corPeca;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public ArrayList<Peca> getPecasCapturadas() {
        return pecasCapturadas;
    }
}
