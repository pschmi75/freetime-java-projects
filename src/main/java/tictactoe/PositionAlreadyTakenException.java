package tictactoe;

public class PositionAlreadyTakenException extends RuntimeException {
    public PositionAlreadyTakenException(String message) {
        super("The position " + message + " is already taken.");
    }
}
