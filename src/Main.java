import Jogo.Jogador;
import Jogo.Tabuleiro;
import Jogo.Xadrez;
import Utils.Cores;

public class Main {

    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.imprimirConfiguracaoAtual();
        //Jogador jogador1 = new Jogador("Matheus", Cores.BRANCO);
        //Jogador jogador2 = new Jogador("Muriel", Cores.PRETO);
        //Xadrez xadrez = new Xadrez(tabuleiro, jogador1, jogador2);
    }

}
