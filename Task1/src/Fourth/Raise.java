package Fourth;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Raise {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter digit number: ");
        try {
            int number = scanner.nextInt();
            // название переменной - номер цифры справа исходного числа
            int first = number % 10;
            int second = number / 10 % 10;
            int third = number / 100 % 10;
            int fourth = number / 1000 % 10;

            if (first <= second && second <= third &&  third <= fourth) {
                System.out.println("The sequence decreases.");
            }
            else if (first >= second && second >= third && third >= fourth) {
                System.out.println("The sequence increases.");
            }
            else {
                System.out.println("No sequence.");
            }

            /*
            int numb[] = new int[4];
            for (int i = 0; i < 4; i++) {
                numb[i] = number / (int)Math.pow(10, i) % 10;

            if (numb[0] <= numb[1] && numb[1] <= numb[2] && numb[2] <= numb[3]) {
                System.out.println("The sequence decreases.");
            }
            else if (numb[0] >= numb[1] && numb[1] >= numb[2] && numb[2] >= numb[3]) {
                System.out.println("The sequence increases.");
            }
            else {
                System.out.println("No sequence.");
            */

        }
        catch (InputMismatchException e) {
            System.out.println("Don't use any symbols except numbers.");
        }
    }
}
