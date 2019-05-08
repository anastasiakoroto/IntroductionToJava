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
            int sevenDigit = (int)Math.pow(10, 6);
            int fiveDigit = 99999;
            if (number < sevenDigit && number > fiveDigit) {
                // название переменной - номер цифры справа исходного числа
                int first = number % 10;
                int second = number / 10 % 10;
                int third = number / 100 % 10;
                int fourth = number / 1000 % 10;
                int fifth = number / 10000 % 10;
                int sixth = number / 100000 % 10;
                int sumOfNumbers = first + second + third + fourth + fifth + sixth;
                double multOfNumbers = first * second * third * fourth * fifth * sixth;
                double arithmMean = (double) sumOfNumbers / 6;
                double geomMean = Math.pow(multOfNumbers, 1.0 / 6);
                System.out.println("The arithmetic mean of " + number + ": " + arithmMean);
                System.out.println("The geometric mean of " + number + ": " + geomMean);
            }
            else {
                System.out.println("Enter six-digit number, please.");
            }
            /* variant no.2
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
            double geomMean = Math.pow(multOfNumbers, 1.0 / 6); */
        }
        catch (InputMismatchException e) {
            System.out.println("Don't use any symbols. Numbers only.");
        }
    }
}
