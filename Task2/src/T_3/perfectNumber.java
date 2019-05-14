package T_3;

import java.util.Scanner;

public class perfectNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        if (divider(a)) {
            System.out.println("The number " + a + " is perfect!");
        }
        else {
            System.out.println("The number " + a + " isn't perfect.");
        }
    }

    private static boolean divider(int a) {
        boolean ifPerfect = false;
        int count = 0;
        for (int i = 1; i < a; i++) {
            if (a % i == 0){
                count += i;
            }
        }
        if (count == a) {
            ifPerfect = true;
        }
        return ifPerfect;
    }
}
