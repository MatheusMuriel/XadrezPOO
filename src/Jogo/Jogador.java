package Jogo;

import java.util.ArrayList;
import Pecas.Abstract.Peca;
import Utils.Cores;

public class Jogador {
    String nome;
    String corPeca;
    double pontuacao;

    /** Construtor que recebe um nome e uma cor de peça. */
    public Jogador(String nome, Cores corPeca) {

    }

    /** Retorna uma lista contendo as peças do adversário que foram adquiridas ao longo da partida. */
    public ArrayList<Peca> listarPecasAdquiridas() {

        return new ArrayList<>();
    }
}
