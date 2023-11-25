package TU_Java.SAA;

public class DigitSearch {
    public static void main(String[] args) {
        int number = 15483;
        int digitToFind = 5;

        boolean isDigitPresent = searchDigit(number, digitToFind);

        if(isDigitPresent) {
            System.out.println("cifrata" + digitToFind + "se sreshta w chisloto " + number);
        } else {
            System.out.println("Cifrata" + digitToFind + "Ne se sreshta v chisloto " + number);
        }
    }

    public static boolean searchDigit(int num, int digit) {
        if (num == 0) {
            return false;
        } else if(num % 10 == digit) {
            return true;
        } else {
            return searchDigit(num / 10, digit);
        }
    }
}