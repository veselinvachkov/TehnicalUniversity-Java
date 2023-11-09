package TU_Java.week_4;

public class WrongUserException extends Exception {
    public WrongUserException() {
        super("Invalid user. The length of the username must be 3-15 symbols and should only contain letters, digits, hyphens, and underscores.");
    }
}

