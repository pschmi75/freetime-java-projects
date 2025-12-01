package chess;

import java.util.Objects;
import java.util.Scanner;

public class Chessboard {

    private Piece[][] board = new Piece[8][8];

    public boolean hasPiece(Position pos, String pTeam) {
        if (!pos.isValid()) throw new IllegalArgumentException("Invalid position");
        else if (!pTeam.equals("black") && !pTeam.equals("white")) throw new IllegalArgumentException("Invalid team");
        else return (board[pos.getX() - 1][pos.getY() - 1] != null && board[pos.getX() - 1][pos.getY() - 1].team.equals(pTeam));
    }

    /** Freiwillige Arbeit :) */
    public void promotePawn(Position pos) {
        boolean terminate = false;
        while (!terminate) {
            Piece current = board[pos.getX() - 1][pos.getY() - 1];
            Scanner input = new Scanner(System.in);
            System.out.println("You can promote your pawn at " + pos + ". Do you wish to promote? [y/n]");
            String text = input.next();
            while (!text.equals("y") && !text.equals("n")) {
                System.out.println("Invalid answer. Please select yes [y] or no [n].");
                text = input.next();
            }
            if (text.equals("n")) terminate = true;
            System.out.println("Which piece would you like to promote to? Your options: Bishop [b], Rook [r], Knight [k] or Queen [q]");
            text = input.next();
            while (!text.equals("b") && !text.equals("r") && !text.equals("k") && !text.equals("q") && !text.equals("e")) {
                System.out.println("Invalid answer. Please select one of the above, or select exit [e] to terminate.");
                text = input.next();
            }
            if (text.equals("e")) terminate = true;
            Piece temp = null;
            switch (text) {
                case "b": temp = new Bishop(pos, current.getTeam()); break;
                case "r": temp = new Rook(pos, current.getTeam()); break;
                case "k": temp = new Knight(pos, current.getTeam()); break;
                case "q": temp = new Queen(pos, current.getTeam()); break;
            }
            board[pos.getX() - 1][pos.getY() - 1] = temp;
        }
    }
}
