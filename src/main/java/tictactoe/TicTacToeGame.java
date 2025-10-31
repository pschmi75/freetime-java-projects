package tictactoe;

public class TicTacToeGame {
    protected char[][] board = new char[3][3];

    public TicTacToeGame() {
        resetBoard();
    }

    public void play(char row, int col, char team) {
        if (row < 'A' || row > 'C' || col < 1 || col > 3) throw new  NotOnBoardException("" + row + col);
        else board[row - 'A'][col - 1] = team;
    }

    protected void winner(char team) {
        System.out.println("Team " + team + " wins!");
    }

    protected void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    @Override
    public String toString() {
        return
        "\n" + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2] +
        "\n-------------" +
        "\n" + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2] +
        "\n-------------" +
        "\n" + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2];
    }
}
