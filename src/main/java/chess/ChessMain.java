package chess;

public class ChessMain {

    public static void main(String[] args) {
        // Test eines Turms
        Rook rook = new Rook(new Position(4, 5), "white");
        System.out.println(rook);
        rook.moveTo(new Position(4, 1));
        System.out.println(rook);
        System.out.println(rook.getMoveList());

        // Test eines Springers
        Knight knight = new Knight(new Position(5, 4), "white");
        System.out.println(knight);
        knight.moveTo(new Position(6, 6)); // Mitten auf dem Feld
        System.out.println(knight);
        System.out.println(knight.getMoveList());
        knight.moveTo(new Position(8, 5)); // Am Rand des Feldes
        System.out.println(knight);
        System.out.println(knight.getMoveList());

        // Test eines Laeufers
        Bishop bishop = new Bishop(new Position(4, 5), "white");
        System.out.println(rook);
        bishop.moveTo(new Position(5, 6));
        System.out.println(bishop);
        System.out.println(bishop.getMoveList());
    }

}
