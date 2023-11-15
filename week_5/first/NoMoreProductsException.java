package TU_Java.week_5.first;

public class NoMoreProductsException extends Throwable {
    public NoMoreProductsException(String message) {
        System.out.println(message);
    }
}