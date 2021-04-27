import Jogo.Jogador;
import Jogo.Tabuleiro;
import Jogo.Xadrez;
import Utils.Cores;
import Utils.StatusJogo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            while (!verificarInput(input)) {
                System.out.println("Entrada invalida! Por favor digite novamente");
                System.out.print("Jogada: ");
                input = scanner.nextLine();
            }
            System.out.println("Entrada Valida");
        }
    }

    private static boolean verificarInput(String input) {
        String[] posicoes = input.split(",");
        if (posicoes.length < 2) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[abcdefghABCDEFGH]{1}[1-8]{1}$");
        Matcher matcher1 = pattern.matcher(posicoes[0]);
        Matcher matcher2 = pattern.matcher(posicoes[1]);
        return matcher1.find() && matcher2.find();
    }

}
