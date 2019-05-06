package Third;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Square {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter radius of big and little circles: ");
        try {
            double r1 = scanner.nextDouble();
            double r2 = scanner.nextDouble();

            if (r1 < r2) {
                System.out.println("R1 must be larger than R1. Try another values.");
            } else {
                System.out.println(squareOfRing(r1, r2));
            }
        }
        catch (InputMismatchException e) {
            System.out.println("No symbols except comma and numbers.");
        }
    }

    public static double squareOfRing(double rBig, double rLittle) {
        double squareOfBig = rBig * rBig * Math.PI;
        double squareOfLittle = rLittle * rLittle * Math.PI;
        return squareOfBig - squareOfLittle;
    }
}

