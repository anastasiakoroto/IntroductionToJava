package Sixth;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {

        System.out.println("Enter seven-digit number: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int number = scanner.nextInt();
            int sixDigit = (int)Math.pow(10, 6);
            int eightDigit = (int)Math.pow(10, 8);
            if (number < eightDigit && number > sixDigit) {
                System.out.println("For number " + number + " the inverted number: " + reverse(number));
            }
            else {
                System.out.println("Enter seven-digit number, please.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Don't use any symbols. Numbers only.");
        }
    }

    private static int reverse(int numb) {

            // название переменной - номер цифры справа
            int first = numb % 10;
            int second = numb / (int) Math.pow(10, 1) % 10;
            int third = numb / (int) Math.pow(10, 2) % 10;
            int forth = numb / (int) Math.pow(10, 3) % 10;
            int fifth = numb / (int) Math.pow(10, 4) % 10;
            int sixth = numb / (int) Math.pow(10, 5) % 10;
            int seventh = numb / (int) Math.pow(10, 6) % 10;
            int newNumb = first * 1000000 + second * 100000 + third * 10000 + forth * 1000
                    + fifth * 100 + sixth * 10 + seventh;

            return newNumb;



        // variant no.2
       /* int newNumb = numb % 10;
        int next;
        for (int i = 0; i < 6; i++) {
            numb = numb / 10;
            next = numb % 10;

            newNumb = newNumb * 10 + next;
        }
        return newNumb;*/
    }
}
