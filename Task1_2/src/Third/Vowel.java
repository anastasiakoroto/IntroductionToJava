package Third;

import java.util.Scanner;

public class Vowel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char letter = scanner.next().charAt(0);

        method1(letter);
        method2(letter);
        method3(letter);
        method4(letter);

    }

    private static void method1(char letter) {
        String vowels = "eEyYuUiIoOaAуУеЕаАоОэЭюЮяЯиИёЁыЫ";
        int check = 0;
        for (int i = 0; i < vowels.length(); i++) {
            if (letter == vowels.charAt(i)) {
                check = 1;
                break;
            }
        }
        if (check == 1) {
            System.out.println("It's a vowel.");
        }
        else {
            System.out.println("It's not a vowel.");
        }
    }

    private static void method2(char letter) {
        int check = 0;
        switch (letter) {
            case 'a':
                check = 1;
                break;
            case 'A':
                check = 1;
                break;
            case 'e':
                check = 1;
                break;
            case 'E':
                check = 1;
                break;
            case 'y':
                check = 1;
                break;
            case 'Y':
                check = 1;
                break;
            case 'u':
                check = 1;
                break;
            case 'U':
                check = 1;
                break;
            case 'i':
                check = 1;
                break;
            case 'I':
                check = 1;
                break;
            case 'o':
                check = 1;
                break;
            case 'O':
                check = 1;
                break;
            case 'а':
                check = 1;
                break;
            case 'А':
                check = 1;
                break;
            case 'у':
                check = 1;
                break;
            case 'У':
                check = 1;
                break;
            case 'е':
                check = 1;
                break;
            case 'Е':
                check = 1;
                break;
            case 'о':
                check = 1;
                break;
            case 'О':
                check = 1;
                break;
            case 'э':
                check = 1;
                break;
            case 'Э':
                check = 1;
                break;
            case 'ы':
                check = 1;
                break;
            case 'Ы':
                check = 1;
                break;
            case 'я':
                check = 1;
                break;
            case 'Я':
                check = 1;
                break;
            case 'ю':
                check = 1;
                break;
            case 'Ю':
                check = 1;
                break;
            case 'ё':
                check = 1;
                break;
            case 'Ё':
                check = 1;
                break;
            case 'и':
                check = 1;
                break;
            case 'И':
                check = 1;
                break;
        }
        if (check == 1) {
            System.out.println("It's a vowel.");
        }
        else {
            System.out.println("It's not a vowel.");
        }
    }

    private static void method3(char letter) {
        String letter_str = String.valueOf(letter);
        if (letter_str.matches("[aeyuioAEYUIO]") || letter_str.matches("[аАуУеЕоОяЯёЁиИюЮэЭыЫ]")) {
            System.out.println("It's a vowel!");
        }
        else {
            System.out.println("It's not a vowel.");
        }
    }

    private static void method4(char letter) {
        String vowels = "eEyYuUiIoOaAуУеЕаАоОэЭюЮяЯиИёЁыЫ";
        String letter_str = String.valueOf(letter);
        if (vowels.contains(letter_str)) {
            System.out.println("It's a vowel!");
        }
        else {
            System.out.println("It's not a vowel.");
        }
    }
}
