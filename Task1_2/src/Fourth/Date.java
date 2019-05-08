package Fourth;

import java.util.Scanner;

public class Date {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        nextDay(day, month, year);
    }

    private static void nextDay(int d, int m, int y) {
        int leapYear = 0; // 1 - leap, 0 - not leap
        int wrong = 0;
        if (y % 400 == 0) {
            leapYear = 1;
        }
        else if (y % 100 == 0) {
            leapYear = 0;
        }
        else if (y % 4 == 0) {
            leapYear = 1;
        }

        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12 ) {
            if (d < 31 & d > 0) {
                d += 1;
            }
            else if (d == 31 && m < 12) {
                d = 1;
                m += 1;
            }
            else if (d == 31 && m == 12) {
                d = 1;
                m = 1;
                y += 1;
            }
            else {
                wrong = 1;
                System.out.println("Wrong data.");
            }
        }
        else if (m == 4 || m == 6 || m == 9 || m == 11) {
            if (d < 30 & d > 0) {
                d += 1;
            }
            else if (d == 30) {
                d = 1;
                m += 1;
            }
            else {
                wrong = 1;
                System.out.println("Wrong data.");
            }

        }
        else if (m == 2) {
            if (leapYear == 1) {
                if (d < 29) {
                    d += 1;
                }
                else if (d == 29) {
                    d = 1;
                    m += 1;
                }
                else {
                    wrong = 1;
                    System.out.println("Wrong data.");
                }
            }
            else if (leapYear == 0) {
                if (d < 28) {
                    d += 1;
                }
                else if (d == 28) {
                    d = 1;
                    m += 1;
                }
                else {
                    wrong = 1;
                    System.out.println("Wrong data.");
                }
            }
        }

        if (wrong == 0) {
            System.out.println("The next day: " + d + "." + m + "." + y);
        }
        else {
            System.out.println("Choose correct date.");
        }
    }
}
