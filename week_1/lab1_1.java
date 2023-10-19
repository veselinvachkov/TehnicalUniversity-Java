package TU_Java.week_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> info = new ArrayList<>();
        System.out.println("Our program is made to build a CV for you!");

        System.out.print("Name: ");
        info.add(scanner.nextLine());
        System.out.print("Age: ");
        info.add(scanner.nextLine());
        System.out.print("What work are you applying for: ");
        info.add(scanner.nextLine());
        System.out.print("Prev experience: ");
        info.add(scanner.nextLine());
        System.out.print("Other: ");
        info.add(scanner.nextLine());

        for (String e : info) {
            System.out.print(e + ", ");
        }
    }
}
