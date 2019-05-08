package Second;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dragon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int amount = scanner.nextInt();
            int heads = 3;
            if (amount >= 0) {
                if (amount <= 200) {
                    heads += 3 * amount;
                } else if (amount <= 300 && amount > 200) {
                    int difference = amount - 200;
                    heads += 3 * 200;
                    heads += difference * 2;
                } else {
                    int difference = amount - 300;
                    heads = 3 * 200 + 3;
                    heads = heads + 200 + difference;
                }
                int eyes = heads * 2;
                System.out.println("New amount of heads through " + amount + " years: " + heads
                        + ". Amount of eyes: " + eyes);
            }
            else {
                System.out.println("No negative age. Use only positive numbers.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Don't use any symbols except numbers.");
        }
    }
}
