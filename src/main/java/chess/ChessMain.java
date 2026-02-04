package chess;

public class ChessMain {

    public static void main(String[] args) {
        Chessboard chess = new Chessboard();
        Queen q = new Queen(new Position(2,3), "white");
        System.out.println(q);
        System.out.println(q.toSimpleString());
    }

}
