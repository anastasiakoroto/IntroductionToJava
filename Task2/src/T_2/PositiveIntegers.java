package T_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PositiveIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println(first(a));

            if (second(a)) {
                System.out.println("It's a palindrome.");
            }
            else {
                System.out.println("It's not a palindrome.");
            }

            if (third(a)) {
                System.out.println("It's a simple number.");
            }
            else {
                System.out.println("It's not simple.");
            }

            forth(a);
            fifth(a, b);
            System.out.println("Amount of unique numbers: " + sixth(a));
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input. Use numbers only.");
        }

    }


    private static int first (int a) {
        String number = String.valueOf(a);
        int maxNumb = 0;
        for (int i = 0; i < number.length(); i++) {
            int now = Integer.valueOf(String.valueOf(number.charAt(i)));
            if (now > maxNumb) {
                maxNumb = now;
            }
        }
        return maxNumb;
    }

    private static boolean second(int a) {
        String number = String.valueOf(a);
        boolean ifPalindrome = true;
        for (int i = 0; i < (number.length() - 1) / 2; i++) {
            String left = String.valueOf(number.charAt(i));
            int ind = number.length() - i - 1;
            String right = String.valueOf(number.charAt(ind));
            if (!left.equals(right)) {
                ifPalindrome = false;
                break;
            }
        }
        return ifPalindrome;
    }

    private static boolean third(int a) {
        boolean ifSimple = true;
        int i = 2;
        while (ifSimple && i < a) {
            if (a % i == 0){
                ifSimple = false;
                break;
            }
            ++i;
        }
        return ifSimple;
    }

    private static void forth(int a) {
        int count = 0;
        for (int i = 2; i < a; i++) {
            int divider = i;
            if (a % divider == 0 && third(divider)) {
                System.out.println("For number " + a + " the simple divider: " + divider);
                count += 1;
            }
        }
        if (count == 0) {
            System.out.println("The number hasn't simple dividers.");
        }
    }

    private static void fifth(int a, int b) {
        int nod = 0;
        int nok;
        int smaller;
        int larger;
        if (a < b) {
            smaller = a;
            larger = b;
        }
        else {
            smaller = b;
            larger = a;
        }
        for (int i = 1; i < smaller; i++) {
            if (a % i == 0 && b % i == 0) {
                nod = i;
            }
        }
        int j = 1;
        int suppose = larger * j;
        while ((suppose % larger == 0) && (suppose % smaller != 0)) {
            j += 1;
            suppose = larger * j;
        }
        nok = suppose;
        System.out.println("GCD is equal " + nod + ". HCF is equal " + nok);
    }

    private static int sixth(int a) {
        String number = String.valueOf(a);
        int countOfUnique = 0;
        for (int i = 0; i < number.length(); i++) {
            int countSame = 0;
            String now = String.valueOf(number.charAt(i));

            for (int j = 0; j < i; j++) {
                if (now.equals(String.valueOf(number.charAt(j)))) {
                    countSame += 1;
                }
            }
            if (countSame == 0) {
                countOfUnique += 1;
            }
        }
        return countOfUnique;
    }
}
