package First;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            double pointA_x = scanner.nextDouble();
            double pointA_y = scanner.nextDouble();
            double pointB_x = scanner.nextDouble();
            double pointB_y = scanner.nextDouble();
            double pointC_x = scanner.nextDouble();
            double pointC_y = scanner.nextDouble();

            double ab_side = Math.sqrt(Math.pow(pointA_x - pointB_x, 2) + Math.pow(pointA_y - pointB_y, 2));
            double bc_side = Math.sqrt(Math.pow(pointB_x - pointC_x, 2) + Math.pow(pointB_y - pointC_y, 2));
            double ac_side = Math.sqrt(Math.pow(pointA_x - pointC_x, 2) + Math.pow(pointA_y - pointC_y, 2));

            if ((pointA_y == pointB_y && pointB_y == pointC_y) | (pointA_x == pointB_x && pointB_x == pointC_x)) {
                System.out.println("It's not a triangle.");
            }
            else {
                System.out.println("Points -  the vertices of the triangle");
                double ab_sq = ab_side * ab_side;
                double bc_sq = bc_side * bc_side;
                double ac_sq = ac_side * ac_side;
                double diff1 = ab_sq + bc_sq - ac_sq;
                double diff2 = ab_sq + ac_sq - bc_sq;
                double diff3 = bc_sq + ac_sq - ab_sq;

                if (Math.abs(diff1) < 0.001 | Math.abs(diff2) < 0.001 | Math.abs(diff3) < 0.001) {
                    System.out.println("It's a right triangle.");
                }
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Don't use any symbols except numbers.");
        }
    }
}
