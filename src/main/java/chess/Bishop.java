package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bishop extends Piece {

    public Bishop(Position position) {
        super(position);
    }

    @Override
    public List<Position> getMoveList() {
        List<Position> positions = new ArrayList<>();
        for (int i = -4; i <= 4; i++) {
            if (i == 0) continue;
            positions.add(new Position(pos.getX() + i, pos.getY() + i));
            positions.add(new Position(pos.getX() + i, pos.getY() - i));
        }
        return positions.stream().filter(Position::isValid).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Bishop[" + getTeam() + "]:" + getPosition();
    }
}
