package chess;

import java.util.List;

public abstract class Piece {

    protected Position pos;
    protected String team;

    public Piece(Position position, String pTeam) {
        if (position == null) throw new IllegalArgumentException("Position is Null");
        else if (!position.isValid()) throw new IllegalArgumentException("Invalid position");
        else {
            pos = position;
            team = pTeam;
        }
    }

    public Position getPosition() {
        return pos;
    }


    public String getTeam() {
        return this.team;
    }

    public void moveTo(Position pos, Chessboard board) {
        if (!canMoveTo(pos, board)) throw new IllegalArgumentException("Illegal move");
        else this.pos = pos;
    }

    public abstract List<Position> getMoveList(Chessboard board);

    public boolean canMoveTo(Position pos, Chessboard board) {
        return (getMoveList(board).contains(pos));
    }

    public String printMoveList(Chessboard board) {
        List<Position> list = getMoveList(board);
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i));
            if (i != list.size() - 1) str.append(", ");
            else str.append("]");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + this.getTeam() + "]: " + this.getPosition();
    }

    public String toSimpleString() {
        return this.getClass().getSimpleName() + "[" + this.getTeam() + "]";
    }
}
