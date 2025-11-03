package tictactoe;

import static java.lang.System.exit;

public class TicTacToeGame {
    protected char[][] board;
    protected char lastPlayer = 'O';

    public TicTacToeGame() {
        board = new char[3][3];
        resetBoard();
        System.out.println(this);
    }

    protected boolean hasWon(char row, int col, char player) {
        boolean won = false;
        int amountTrue = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][col - 1] == player) amountTrue++;
        }
        if (amountTrue == board.length) won = true;

        amountTrue = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[row - 'A'][i] == player) amountTrue++;
        }
        if (amountTrue == board.length) won = true;

        amountTrue = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == player)  amountTrue++;
        }
        if  (amountTrue == board.length) won = true;

        amountTrue = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[board.length - i - 1][i] == player)  amountTrue++;
        }
        if (amountTrue == board.length) won = true;

        return won;
    }

    protected void winner(char player) {
        System.out.println("Player " + player + " wins!");
        exit(67);
    }

    protected void tie() {
        System.out.println("It's a tie!");
        exit(67);
    }

    protected void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    protected boolean boardFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }

    public void play(char row, int col) {
        char player;
        if (lastPlayer == 'X') {
            player = 'O';
            lastPlayer = 'O';
        }
        else {
            player = 'X';
            lastPlayer = 'X';
        }
        if (row < 'A' || row > board.length + 'A' || col < 1 || col > board.length) throw new  NotOnBoardException("" + row + col);
        else if (board[row - 'A'][col - 1] != '-') {
            if (lastPlayer == 'X') lastPlayer = 'O';
            else lastPlayer = 'X';
            throw new PositionAlreadyTakenException("" + row + col);
        }
        else board[row - 'A'][col - 1] = player;

        System.out.println(this);
        if (hasWon(row, col, player)) winner(player);
        if (boardFull()) tie();
    }

    public char getLastPlayer() {
        return lastPlayer;
    }

    @Override
    public String toString() {
        /*return
        "\n" + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2] +
        "\n-------------" +
        "\n" + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2] +
        "\n-------------" +
        "\n" + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2];
        */

        return  "\n   A     B     C\n" +
                "      |     |     \n" +
                "1  " + board[0][0] + "  |  " + board[1][0] +  "  |  " + board[2][0] + "  \n" +
                " _____|_____|_____\n" +
                "      |     |     \n" +
                "2  " + board[0][1] + "  |  " + board[1][1] +  "  |  " + board[2][1] + "  \n" +
                " _____|_____|_____\n" +
                "      |     |     \n" +
                "3  " + board[0][2] + "  |  " + board[1][2] +  "  |  " + board[2][2] + "  \n" +
                "      |     |     \n";
    }
}
