import Jogo.Jogador;
import Jogo.Tabuleiro;
import Jogo.Xadrez;
import Utils.Cores;
import Utils.Posicao;
import Utils.StatusJogo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
//        System.out.println("Digite o nome do jogador das paças Brancas:");
//        System.out.print("Nome: ");
//        String nome01 = scanner.nextLine();
//        System.out.println("Digite o nome do jogador das paças Pretas:");
//        System.out.print("Nome: ");
//        String nome02 = scanner.nextLine();
//        Jogador jogador1 = new Jogador(nome01, Cores.BRANCO);
//        Jogador jogador2 = new Jogador(nome02, Cores.PRETO);
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
            String[] input = scanner.nextLine().split(","); // Todo deixar o input do usuario
            //String[] input = "d2,d4".split(",");

            boolean inputValido = verificarInput(input);
            Posicao[] jogada = { inputValido ? new Posicao(input[0]) : null, inputValido ? new Posicao(input[1]) : null};
            boolean movimentoValido = inputValido && xadrez.isMovimentoValido(jogada);
            boolean jogadaValida = inputValido && movimentoValido;
            while (!jogadaValida) {
                System.out.println("Entrada invalida! Por favor digite novamente");
                System.out.print("Jogada: ");
                input = scanner.nextLine().split(",");
                //String stop = scanner.nextLine();
                //input = "d2,d4".split(",");  // Todo deixar o input do usuario

                inputValido = verificarInput(input);
                jogada[0] = inputValido ? new Posicao(input[0]) : null;
                jogada[1] = inputValido ? new Posicao(input[1]) : null;
                movimentoValido = inputValido && xadrez.isMovimentoValido(jogada);
                jogadaValida = inputValido && movimentoValido;
            }
            xadrez.jogar(jogada);
        }

        System.out.println("Fim de jogo.");
        System.out.println("O jogador " + (
                xadrez.getStatusDoJogo().equals(StatusJogo.JOGADOR1_VENCEU)
                        ? xadrez.getJogador1().getNome() : xadrez.getJogador2().getNome()
                )
                + " venceu"
        );
    }

    private static boolean verificarInput(String[] input) {
        if (input.length < 2) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[abcdefghABCDEFGH]{1}[1-8]{1}$");
        Matcher matcher1 = pattern.matcher(input[0]);
        Matcher matcher2 = pattern.matcher(input[1]);
        return matcher1.find() && matcher2.find();
    }

}
