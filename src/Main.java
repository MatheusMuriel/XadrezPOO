import Jogo.Jogador;
import Jogo.Tabuleiro;
import Jogo.Xadrez;
import Utils.Cores;
import Utils.StatusJogo;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        //tabuleiro.imprimirConfiguracaoAtual();
        Jogador jogador1 = new Jogador("Matheus", Cores.BRANCO);
        Jogador jogador2 = new Jogador("Muriel", Cores.PRETO);
        Xadrez xadrez = new Xadrez(tabuleiro, jogador1, jogador2);
        gameLoop(xadrez);

        System.out.println();
        System.out.println("Obrigado por jogar!");
        System.out.println("Até a proxima :D");
    }

    private static void gameLoop(Xadrez xadrez) {
        while (xadrez.getStatusDoJogo().equals(StatusJogo.EM_JOGO)) {
            xadrez.imprimir();
            System.out.println("Digite sua jogada no formato: \"Origem,Destino\" (Ex. D2,D4)");
            System.out.print("Jogada: ");
            String input = scanner.nextLine();
        }
    }

}
