package tech.arrays.clientmanager.exception;

public class UserNotFoundException extends  RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
