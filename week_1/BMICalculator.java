package TU_Java.week_1;

import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printIntroduction();

        double bmi = getBMI(scanner);

        System.out.println(getStatus(bmi));

        ReportResults(bmi);

    }

    private static void ReportResults(double bmi) {
        System.out.printf("%.2f", bmi);
    }

    private static String getStatus(double bmi) {

        if (bmi <= 18.5){
            return "underweight";
        } else if (bmi <= 25) {
            return "normal";
        } else if (bmi <= 30) {
            return "overweight";
        }else if (bmi > 30){
            return "obese";
        }else {
            return "Error";
        }
    }

    private static double bmiFor(double weight, double height) {
        return weight * 703/ (height*height);
    }

    private static double getBMI(Scanner scanner) {
        System.out.print("Weight: ");
        double weight = Double.parseDouble(scanner.nextLine()) * 2.2046;
        System.out.print("Height: ");
        double height = Double.parseDouble(scanner.nextLine()) * 0.3937;

        double bmi = bmiFor(weight, height);
        return bmi;
    }


    private static void printIntroduction() {
        System.out.println("WELCOME TO THE BMI CALCULATOR");
    }
}
