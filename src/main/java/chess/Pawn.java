package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pawn extends Piece {

    public Pawn(Position position, String pTeam) {
        super(position);
    }

    @Override
    public List<Position> getMoveList() {
        List<Position> positions = new ArrayList<>();
        // Assuming y = 8 is starting line for black and y = 1 for white
        Position newPos;
        if (team.equals("black")) newPos = new Position(pos.getX(), pos.getY() - 1);
        else newPos = new Position(pos.getX(), pos.getY() + 1);
        if (newPos.isValid()) positions.add(newPos);
        // Checking if pawn can capture
        /*
        if (team.equals("black")) {
            newPos = new Position(pos.getX() + 1, pos.getY() - 1);
            if (pos.isValid()) positions.add(newPos);
            newPos = new Position(pos.getX() - 1, pos.getY() - 1);
            if (pos.isValid()) positions.add(newPos);
        } else {
            newPos = new Position(pos.getX() + 1, pos.getY() + 1);
            if (pos.isValid()) positions.add(newPos);
            newPos = new Position(pos.getX() - 1, pos.getY() + 1);
            if (pos.isValid()) positions.add(newPos);
        }
        */
        // All capture moves disabled for now, would need chessboard as parameter in getMoveList(), would break tests
        return positions.stream().filter(Position::isValid).collect(Collectors.toList());
    }


    @Override
    public String toString() {
        return "Pawn[" + getTeam() + "]: " + getPosition();
    }
}
