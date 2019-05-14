package T_4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AmicableNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your diapason: ");
        try {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            for (int i = a; i <= b; i++) {
                for (int j = a; j <= b; j++) {
                    if ((i != j) && amicable(i, j)) {
                        System.out.println(i + " " + j + " - amicable numbers");
                    }
                }
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input. Use only positive numbers.");
        }
    }

    private static boolean amicable(int a, int b) {
        boolean ifAmicable = false;
        int ifB = 0;
        int ifA = 0;
        for (int i = 1; i < a; i++) {
            if (a % i == 0) {
                ifB += i;
            }
        }
        for (int j = 1; j < b; j++) {
            if (b % j == 0) {
                ifA += j;
            }
        }
        if ((a == ifA) && (b == ifB)) {
            ifAmicable = true;
        }
        return ifAmicable;
    }
}
