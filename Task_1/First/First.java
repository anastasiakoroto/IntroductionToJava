package First;

import java.util.InputMismatchException;
import java.util.Scanner;

public class First {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a, b, c:");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();

            if (a == b  && b == c) {
                System.out.println("a, b, c are equal");
            }
            else if (a == b) {
                System.out.println("a and b are equal, c is different ");
            }
            else if (a == c) {
                System.out.println("a and c are equal, b is different");
            }
            else if (b == c) {
                System.out.println("b and c are equal, a is different");
            }
            else {
                System.out.println("a, b, c are different");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input. Enter numbers only");
        }
    }
}
