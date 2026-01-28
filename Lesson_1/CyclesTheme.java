package Lesson_1;

import java.util.Random;

public class CyclesTheme {
    static void main() {
        System.out.println("1. ВЫВОД ASCII-СИМВОЛОВ");
        System.out.printf("%-8s %-11s %s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int code = 33; code < 48; code += 2) {
            System.out.printf("%-9d %-11c %-30s%n",
                    code,
                    (char) code,
                    Character.getName(code));
        }
        for (int code = 'a'; code <= 'z'; code++) {
            if (code % 2 == 0) {
                System.out.printf("%-9d %-11c %-30s%n",
                        code,
                        (char) code,
                        Character.getName(code));
            }
        }
        System.out.println("\n\n2. ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");
        for (int i = 0; i < 5; i++) {
            System.out.print("---------- ");

            for (int j = 0; j < 5 - i; j++) System.out.print("*");
            System.out.print(" ");

            for (int k = 0; k < 1 + 2 * i; k++) System.out.print("^");

            System.out.println();
        }
        System.out.println("\n3. ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ");
        System.out.println("""
                  |  2  3  4  5  6  7  8  9
                --+------------------------""");
        for (int i = 2; i <= 9; i++) {
            System.out.print(i + " | ");
            for (int k = 2; k <= 9; k++) {
                System.out.printf("%2d ", i * k);
            }
            System.out.println();
        }
        System.out.println("\n4. ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК");
        int count = 0;
        for (int i = 1; i < 24; i += 2) {
            System.out.printf("%2d ", i);
            count++;
            if (count % 5 == 0) {
                System.out.println();
            }
        }
        if (count % 5 != 0) {
            for (int i = 0; i < 5 - (count % 5); i++) {
                System.out.printf("%2d ", 0);
            }
            System.out.println();
        }
        System.out.println("\n5. ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX");
        int a = 10;
        int b = 5;
        int c = -1;
        int min;
        int max;
        if (a < b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }
        if (c < min) {
            min = c;
        }
        if (c > max) {
            max = c;
        }
        System.out.print("Числа в интервале (" + min + ", " + max + ") в порядке убывания: ");
        for (int i = max - 1; i > min; i--) {
            System.out.print(i);
            if (i > min + 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        System.out.println("\n\n6. РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ");
        int number = 2234321;

        int original = number;
        int reversed = 0;
        while (original > 0) {
            reversed = reversed * 10 + original % 10;
            original /= 10;
        }

        original = number;
        int countTwos = 0;
        while (original > 0) {
            if (original % 10 == 2) {
                countTwos++;
            }
            original /= 10;
        }
        String evenOddTwos = (countTwos % 2 == 0) ? "четным" : "нечетным";

        boolean isPalindrome = (number == reversed);
        String palindromeStatus = isPalindrome ? "палиндром" : "не палиндром";

        System.out.printf("%d - %s с %s (%d) количеством двоек%n",
                reversed, palindromeStatus, evenOddTwos, countTwos);
        System.out.println("\n7. ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА");
        int originalNum = 101002;
        int firstHalf = originalNum / 1000;
        int secondHalf = originalNum % 1000;
        int sumFirst = 0;
        int tempFirst = firstHalf;
        while (tempFirst > 0) {
            sumFirst += tempFirst % 10;
            tempFirst /= 10;
        }
        int sumSecond = 0;
        int tempSecond = secondHalf;
        while (tempSecond > 0) {
            sumSecond += tempSecond % 10;
            tempSecond /= 10;
        }
        boolean isLucky = (sumFirst == sumSecond);
        System.out.println(originalNum + " - " + (isLucky ? "счастливое число" : "несчастливое число"));
        System.out.printf("Сумма цифр %03d = %d%n", secondHalf, sumSecond);
        System.out.printf("Сумма цифр %03d = %d%n", firstHalf, sumFirst);

        System.out.println("\n8. ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ");
        StringBuilder generatedPassword = new StringBuilder();
        Random random = new Random();

        boolean containsDigit = false;
        boolean containsUppercase = false;
        boolean containsSpecialChar = false;
        for (int position = 0; position < 8; position++) {
            char currentSymbol = (char) random.nextInt(33, 127);
            generatedPassword.append(currentSymbol);

            if (Character.isUpperCase(currentSymbol)) {
                containsUppercase = true;
            } else if (Character.isDigit(currentSymbol)) {
                containsDigit = true;
            } else if (!Character.isLetterOrDigit(currentSymbol)) {
                containsSpecialChar = true;
            }
        }
        String securityLevel = "Слабый";
        if (generatedPassword.length() >= 8 &&
                containsUppercase &&
                containsDigit &&
                containsSpecialChar) {
            securityLevel = "Надёжный";
        } else if (generatedPassword.length() >= 8 &&
                (containsUppercase || containsDigit)) {
            securityLevel = "Средний";
        }
        System.out.println("Пароль: " + generatedPassword);
        System.out.println("Надежность: " + securityLevel);
    }
}
