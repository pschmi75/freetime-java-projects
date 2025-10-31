package tictactoe;

public class TestTicTacToeGame {

    private static TicTacToeGame game = new TicTacToeGame();

    public static void main(String[] args) {
        TestPlay();
        TestToString();
    }

    static void TestToString() {
        System.out.println(game.toString());
    }

    static void TestPlay() {
        game.play('A', 1, 'X');
    }
}
