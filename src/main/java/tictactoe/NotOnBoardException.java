package tictactoe;

public class NotOnBoardException extends RuntimeException {
    public NotOnBoardException(String message) {
        super(message + "is not a position on the board. Please choose a valid position in the format \"[row][column]\".");
    }
}
