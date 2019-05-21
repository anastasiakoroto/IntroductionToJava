import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Size of matrix: ");
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (n <= 0 || m <= 0) {
                System.out.println("Enter positive size of matrix. Try again.");
            }
            else {
                double massive[][] = new double[n][m];
                System.out.println("The value diapason of matrix: ");
                int lowOfDiapason = scanner.nextInt();
                int highOfDiapason = scanner.nextInt();

                Matrix.matrixActions(lowOfDiapason, highOfDiapason, massive);
            }
        }
        catch (InputMismatchException e){
            System.out.println("Wrong input.");
        }
    }
}

