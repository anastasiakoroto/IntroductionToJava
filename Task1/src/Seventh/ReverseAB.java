package Seventh;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReverseAB {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a, b:");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("a: " + a + ", b: " + b);

            if (a != b) {
                a += b;
                b = a - b;
                a -= b;
            }
            System.out.println("New a: " + a + ", new b: " + b);
        }
        catch (InputMismatchException e) {
            System.out.println("Don't use any symbols. Integer numbers only.");
        }
    }
}
