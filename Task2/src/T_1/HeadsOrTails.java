package T_1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class HeadsOrTails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of throws: ");
        try {
            int n = scanner.nextInt();

            flipping(n);
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong value. Use numbers only.");
        }
    }

    private static void flipping (int numberOfFlip) {
        Random r = new Random();

        int heads = 0;
        int tails = 0;

        for (int i = 0; i < numberOfFlip; i++) {
            int headOrTail = r.nextInt(2);
            if (headOrTail == 1) {
                heads += 1;
            }
            else {
                tails += 1;
            }
        }
        System.out.println("Heads: " + heads + ". Tails: " + tails);
    }
}
