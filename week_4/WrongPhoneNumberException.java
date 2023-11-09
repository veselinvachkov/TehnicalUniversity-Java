package TU_Java.week_4;

public class WrongPhoneNumberException extends Exception {
    public WrongPhoneNumberException() {
        super("Invalid phone number. Provide a valid phone number.");
    }
}
