package TU_Java.SAA.Kursova_11;

public class Kursova_11 {
    public static void main(String[] args) {
        int A = 1;
        int B = 10001;

        int sum = sumOfDigitsInRange(A, B);
        System.out.println("Сумата на цифрите в интервала [" + A + "..." + B + "] е: " + sum);
    }

    // Рекурсивна функция за намиране на сумата на цифрите на число
    private static int sumOfDigits(int number) {
        if (number == 0) {
            return 0;
        }
        return number % 10 + sumOfDigits(number / 10);
    }

    // Рекурсивна функция за намиране на сумата на цифрите на числата в интервала [A...B]
    private static int sumOfDigitsInRange(int A, int B) {
        if (A > B) {
            return 0;
        }
        return sumOfDigits(A) + sumOfDigitsInRange(A + 1, B);
    }
}
