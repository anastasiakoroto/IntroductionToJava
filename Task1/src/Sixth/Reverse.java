package Sixth;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {

        System.out.println("Enter seven-digit number: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int number = scanner.nextInt();
            System.out.println("For number " + number + " the inverted number: " + reverse(number));
        }
        catch (InputMismatchException e) {
            System.out.println("Don't use any symbols. Numbers only.");
        }
    }

    private static int reverse(int numb) {
        int newNumb = numb % 10;
        int next;
        for (int i = 0; i < 6; i++) {
            numb = numb / 10;
            next = numb % 10;

            newNumb = newNumb * 10 + next;
        }
        return newNumb;
    }
}

