package tictactoe;

import java.util.Scanner;

public class TestTicTacToeGameAUTO {

    private static final TicTacToeGame game = new TicTacToeGame();

    public static void main(String[] args) {
        //TestPlay();
        TestTakenPosition();
        TestToString();
    }

    static void TestToString() {
        System.out.println(game.toString());
    }

    static void TestPlay() {
        game.play('B', 2);
        game.play('A', 1);
        game.play('C', 1);
        game.play('A', 2);
        game.play('A', 3);
    }

    static void TestTakenPosition() {
        try {
            game.play('B', 2);
            game.play('A', 1);
            game.play('C', 1);
            game.play('B', 2);
            game.play('A', 3);
        } catch (RuntimeException e) {
            System.out.println("\n" + e.getMessage());
        }
        }
}
