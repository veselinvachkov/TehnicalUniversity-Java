package TU_Java.SAA;

public class Exercise_1 {
    public static void main(String[] args) {
        int[] numbers = {1, 4, 7, 22, 2, 34, 5};
        int n = numbers.length;
        System.out.println(recursive_max(numbers, n));
    }

    public static int recursive_max(int[] array, int len) {
        if (len == 1) {
            return array[0];
        }
        return Math.max(array[len - 1], recursive_max(array, len-1));
    }
}