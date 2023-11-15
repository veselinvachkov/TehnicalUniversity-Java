package Vesko.first;

public class WrongPhoneNumberException extends Throwable {
    public WrongPhoneNumberException(String message) {
        System.out.println(message);
    }
}