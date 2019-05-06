package Forth;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Raise {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter digit number: ");
        try {
            int number = scanner.nextInt();
            int numb[] = new int[4];
            for (int i = 0; i < 4; i++) {
                numb[i] = number / (int)Math.pow(10, i) % 10;

            }
            if (numb[0] <= numb[1] && numb[1] <= numb[2] && numb[2] <= numb[3]) {
                System.out.println("The sequence decreases.");
            }
            else if (numb[0] >= numb[1] && numb[1] >= numb[2] && numb[2] >= numb[3]) {
                System.out.println("The sequence increases.");
            }
            else {
                System.out.println("No sequence.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Don't use any symbols except numbers.");
        }
    }
}
