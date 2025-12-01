package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Math;

public class Knight extends Piece {

    public Knight(Position position) {
        super(position);
    }

    @Override
    public List<Position> getMoveList() {
        List<Position> positions = new ArrayList<>();
        for (int x= -2; x <= 2 ; x++) {
            if (x == 0) continue;
            int y = 3 - Math.abs(x);
            // Checkt beide Seiten
            positions.add(new Position(pos.getX() + x, pos.getY() + y));
            positions.add(new Position(pos.getX() + x, pos.getY() - y));
        }
        return positions.stream().filter(Position::isValid).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Knight[" + getTeam() + "]: " + getPosition();
    }
}
