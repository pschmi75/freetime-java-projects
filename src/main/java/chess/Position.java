package chess;

public class Position {

    int posX = 0;
    int posY = 0;

    /**
     * Setzt die Position auf den Wert (x/y).
     *
     * @param x Position
     * @param y Position
     */
    public Position(int x, int y) {
        posX = x;
        posY = y;
        if (!isValid()) {
            posX = 0;
            posY = 0;
        }
    }

    /**
     * Gibt die x-Koordinate zurueck.
     *
     * @return x-Position
     */
    public int getX() {
        return posX;
    }

    /**
     * Gibt die y-Koordinate zurueck.
     *
     * @return y-Position
     */
    public int getY() {
        return posY;
    }

    /**
     * Gibt zurueck, ob die Positionen this und o gleich sind.
     *
     * @param o Objekt mit dem verglichen werden soll
     * @return true, wenn o ein Position Objekt ist und x und y gleich sind, ansonsten false
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        return this.getX() == ((Position) o).getX() && this.getY() == ((Position) o).getY();
    }

    /**
     * Gibt zurueck, ob die Position gueltig (d.h. innerhalb des Schachbretts) ist.
     *
     * @return true, wenn x und y im Intervall [1,8], ansonten false
     */
    public boolean isValid() {
        return !(getX() < 1 || getY() < 1 || getX() > 8 || getY() > 8);
    }

    /**
     * Gibt eine String-Darstellung der Position zurueck.
     *
     * @return Ausgabe String
     */
    @Override
    public String toString() {
        return "(" + getX() + "/" + getY() + ")";
    }

}
