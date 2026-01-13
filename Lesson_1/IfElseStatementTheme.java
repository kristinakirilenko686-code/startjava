package Lesson_1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {

    static void main() {
        System.out.println("\n1. ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA");
        boolean isMale = true;
        if (!isMale) {
            System.out.print("Вы девушка.");
        } else {
            System.out.print("Вы мужчина.");
        }

        int age = 47;
        if (age > 18) {
            System.out.print(" Вам больше 18 лет.");
        } else {
            System.out.print(" Вам 18 или менее лет.");
        }

        double height = 1.8;
        if (height < 1.8) {
            System.out.print(" Рост меньше 1.8 м.");
        } else {
            System.out.print(" Рост 1.8 м или более.");
        }

        System.out.println("\n2. ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ");
        int stepsToday = 5698;
        int stepsYesterday = 9878;

        System.out.println("Вчера: " + stepsYesterday + " шагов");
        System.out.println("Сегодня: " + stepsToday + " шагов");

        if (stepsToday > stepsYesterday) {
            System.out.println("Сегодня прошли больше чем вчера");
        } else if (stepsToday < stepsYesterday) {
            System.out.println("Сегодня прошли меньше чем вчера");
        } else {
            System.out.println("Вы прошли одинаковое колличество шагов");
        }
        double average = (stepsYesterday + stepsToday) / 2.0;
        System.out.printf("Среднее: %.1f шагов", average);

        System.out.println("\n3. ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ");
        int guestCount = 15;
        if (guestCount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestCount % 2 == 0) {
            System.out.println("Записалось " + guestCount + " гостей. Можно формировать пары для конкурсов.");
        } else if (guestCount % 2 != 0) {
            System.out.println("Записалось " + guestCount + " гостей. Нужны индивидуальные задания.");
        } else if (guestCount < 0) {
            System.out.println("Ошибка: отрицательное количество гостей " + guestCount);
        }

        System.out.println("\n4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");
        String nickname = "Xg8ig";
        char firstSymbol = nickname.charAt(0);

        System.out.println("Способ 1 (проверка диапазона)");
        System.out.print("  Имя '" + nickname + "' начинается с ");
        if (firstSymbol >= 'a' && firstSymbol <= 'z') {
            System.out.println("маленькой буквы " + firstSymbol);
        } else if (firstSymbol >= 'A' && firstSymbol <= 'Z') {
            System.out.println("большой буквы " + firstSymbol);
        } else if (firstSymbol >= '0' && firstSymbol <= '9') {
            System.out.println("цифры " + firstSymbol);
        } else {
            System.out.println("символа " + firstSymbol);
        }

        System.out.println("\nСпособ 2 (методы Character)");
        System.out.print("  Имя " + "'" + nickname + "'" + " начинается с ");
        if (Character.isLowerCase(firstSymbol)) {
            System.out.println("маленькой буквы " + firstSymbol);
        } else if (Character.isUpperCase(firstSymbol)) {
            System.out.println("большой буквы " + firstSymbol);
        } else if (Character.isDigit(firstSymbol)) {
            System.out.println("цифры " + firstSymbol);
        } else {
            System.out.println("символа " + firstSymbol);
        }

        System.out.println("\n5. ИНВЕНТАРИЗАЦИЯ");
        int dbSerialNumber = 467;
        int serialNumberOfObject = 957;

        if (dbSerialNumber == serialNumberOfObject) {
            System.out.print("[№" + serialNumberOfObject + "]: компьютер на 3-м этаже в кабинете 2");
        } else {
            boolean isEqual = (dbSerialNumber % 10) == (serialNumberOfObject % 10);
            boolean isEqualTens = (dbSerialNumber / 10 % 10) == (serialNumberOfObject / 10 % 10);
            boolean isEqualHundreds = (dbSerialNumber / 100) == (serialNumberOfObject / 100);

            if (!isEqual && !isEqualTens && !isEqualHundreds) {
                System.out.print("[№" + serialNumberOfObject + "]: оборудование не идентифицировано");
            } else {
                System.out.printf("""
                                Нет полного совпадения:
                                База данных: [№%d]
                                Фактический: [№%s%s%s]""", dbSerialNumber,
                        isEqualHundreds ? dbSerialNumber % 10 : "_",
                        isEqualTens ? dbSerialNumber / 10 % 10 : "_",
                        isEqual ? dbSerialNumber / 100 : "_");
            }
        }
        System.out.println("\n6. ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        System.out.println("Способ 1 (float)");
        float deposit = 321123.79f;
        float interestRate;
        if (deposit < 1000000) {
            interestRate = 0.05f;
        } else if (deposit <= 300000) {
            interestRate = 0.07f;
        } else {
            interestRate = 0.10f;
        }
        float interestAmount = deposit * interestRate;
        float totalAmount = deposit + interestAmount;
        System.out.println("Сумма вклада: " + deposit + " руб.");
        System.out.println("Сумма начисленного %: " + interestAmount + " руб.");
        System.out.println("Итоговая сумма с %: " + totalAmount + " руб.");

        System.out.println("\nСпособ 2 (BigDecimal)");
        BigDecimal depositBd = new BigDecimal("321123.79");
        BigDecimal interestRateBd;
        if (depositBd.compareTo(new BigDecimal("100000")) < 0) {
            interestRateBd = new BigDecimal("0.05"); // 5%
        } else if (depositBd.compareTo(new BigDecimal("300000")) <= 0) {
            interestRateBd = new BigDecimal("0.07"); // 7%
        } else {
            interestRateBd = new BigDecimal("0.10"); // 10%
        }
        BigDecimal interestAmountBd = depositBd
                .multiply(interestRateBd)
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalAmountBd = depositBd
                .add(interestAmountBd)
                .setScale(2, RoundingMode.HALF_UP);
        System.out.println("Сумма вклада: " + depositBd + " руб.");
        System.out.println("Сумма начисленного %: " + interestAmountBd + " руб.");
        System.out.println("Итоговая сумма с %: " + totalAmountBd + " руб.");

        System.out.println("\n7. ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ");
        int historyPercent = 59;
        int historyGrade;

        if (historyPercent > 91) {
            historyGrade = 5;
        } else if (historyPercent > 73){
            historyGrade = 4;
        } else if (historyPercent > 60) {
            historyGrade = 3;
        } else {
            historyGrade = 2;
        }
        int csPercent = 92;
        int csGrade;
        if (csPercent > 91) {
            csGrade = 5;
        } else if (csPercent > 73) {
            csGrade = 4;
        } else if (csPercent > 60) {
            csGrade = 3;
        } else {
            csGrade = 2;
        }
        double averageGrade = (historyGrade + csGrade) / 2.0;
        double averagePercent = (historyPercent + csPercent) / 2.0;
        System.out.println("Средний балл: " + averageGrade);
        System.out.println("Средний %: " + averagePercent);

        System.out.println("\n8. РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ");
        BigDecimal monthlyRentCost1 = new BigDecimal("5123.018");
        BigDecimal monthlyProdCost1 = new BigDecimal("9001.729");
        BigDecimal monthlySales1 = new BigDecimal("13025.233");

        BigDecimal profit1 = monthlySales1.subtract(monthlyProdCost1)
                .subtract(monthlyRentCost1)
                .multiply(BigDecimal.valueOf(12))
                .setScale(2, RoundingMode.HALF_DOWN);

        if (profit1.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("Прибыль за год: +" + profit1);
        } else {
            System.out.println("Прибыль за год: " + profit1);
        }
    }
}