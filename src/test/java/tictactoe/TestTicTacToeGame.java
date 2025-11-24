package tictactoe;

import java.util.Scanner;

public class TestTicTacToeGame {

    private static final TicTacToeGame game = new TicTacToeGame();

    public static void main(String[] args) {
        TestPlay();
        //TestToString();
    }

    static void TestToString() {
        System.out.println(game.toString());
    }

    static void TestPlay() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                String temp = input.nextLine();
                char row =  temp.charAt(0);
                int column =  temp.charAt(1) - '0';
                game.play(row, column);
            } catch (RuntimeException e) {
                System.out.println("\n" + e.getMessage());
            }
        }
    }
}
