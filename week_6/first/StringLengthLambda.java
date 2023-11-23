package TU_Java.week_6.first;
import TU_Java.week_6.first.StringComparator;
import TU_Java.week_6.first.StringFunction;

import java.util.Arrays;
import java.util.List;

public class StringLengthLambda {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "22", "333", "4444", "55555");

        int maxLength = findStringLength(strings, String::length, Integer::compare);
        int minLength = findStringLength(strings, String::length, Integer::compare);


        System.out.println("Max: " + maxLength);
        System.out.println("Min: " + minLength);
    }

    private static int findStringLength(List<String> strings, StringFunction function, StringComparator comparator) {
        return strings.stream()
                .mapToInt(function::apply)
                .reduce((a, b) -> comparator.compare(a, b) > 0 ? a : b)
                .orElse(0);
    }
}