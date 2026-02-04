package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bishop extends Piece {

    public Bishop(Position position, String pTeam) {
        super(position, pTeam);
    }

    @Override
    public List<Position> getMoveList(Chessboard board) {
        List<Position> positions = new ArrayList<>();
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            positions.add(new Position(pos.getX() + i, pos.getY() + i));
            positions.add(new Position(pos.getX() + i, pos.getY() - i));
        }
        return positions.stream().filter(Position::isValid).collect(Collectors.toList());
    }
}
