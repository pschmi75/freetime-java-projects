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

    public void moveTo(Position pos) {
        if (!canMoveTo(pos)) throw new IllegalArgumentException("Illegal move");
        else this.pos = pos;
    }

    public abstract List<Position> getMoveList();

    public boolean canMoveTo(Position pos) {
        return (getMoveList().contains(pos));
    }

    public String printMoveList() {
        List<Position> list = getMoveList();
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i));
            if (i != list.size() - 1) str.append(", ");
            else str.append("]");
        }
        return str.toString();
    }
}
