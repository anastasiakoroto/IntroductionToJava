package Second;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dinosaur {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter weight of dinosaur(kg): ");
            double weightKg = scanner.nextDouble();

            if (weightKg >= 0) {
                double weightT = weightKg / 1000;
                double weightG = weightKg * 1000;
                double weightMg = weightG * 1000;

                System.out.println("Weight in kilograms: " + weightKg + '\n'
                        + "Weight in grams: " + weightG + '\n'
                        + "Weight in milligrams: " + weightMg + '\n'
                        + "Weight in tons: " + weightT);
            }
            else {
                System.out.println("No negative numbers. Choose another value.");
            }

        }
        catch (InputMismatchException e) {
            System.out.println("No symbols except comma and numbers. Try to enter a value again.");
        }
    }
}
