package Fifth;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter six-digit number: ");
            int number = scanner.nextInt();
            if (number < 0) {
                number = -number;
            }

            int numb[] = new int[6];
            for (int i = 0; i < 6; i++) {
                numb[i] = number / (int) Math.pow(10, i) % 10;
            }
            int sumOfNumbers = 0;
            double multOfNumbers = 1;

            for (int i = 0; i < 6; i++) {
                sumOfNumbers += numb[i];
                multOfNumbers *= numb[i];
            }
            double arithmMean = (double) sumOfNumbers / 6;
            double geomMean = Math.pow(multOfNumbers, 1.0 / 6);
            System.out.println("The arithmetic mean of " + number + ": " + arithmMean);
            System.out.println("The geometric mean of " + number + ": " + geomMean);
        }
        catch (InputMismatchException e) {
            System.out.println("Don't use any symbols. Numbers only.");
        }
    }
}
