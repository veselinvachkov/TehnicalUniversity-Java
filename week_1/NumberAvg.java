package TU_Java.week_1;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class NumberAvg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OptionalDouble number = Arrays.stream(Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .asDoubleStream()
                .average();

        System.out.println("Average: " + number.getAsDouble());
    }
}
