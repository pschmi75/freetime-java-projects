package chess;

public class Position {

    int posX = 0;
    int posY = 0;

    public Position(int x, int y) {
        posX = x;
        posY = y;
        if (!isValid()) {
            posX = 0;
            posY = 0;
        }
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        return this.getX() == ((Position) o).getX() && this.getY() == ((Position) o).getY();
    }

    public boolean isValid() {
        return !(getX() < 1 || getY() < 1 || getX() > 8 || getY() > 8);
    }

    @Override
    public String toString() {
        return "(" + getX() + "|" + getY() + ")";
    }

}
