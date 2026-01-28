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

        System.out.println("\n\n2. ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ");
        int stepsToday = 5698;
        int stepsYesterday = 9878;

        System.out.println("Вчера: " + stepsYesterday + " шагов");
        System.out.println("Сегодня: " + stepsToday + " шагов");

        if (stepsToday > stepsYesterday) {
            System.out.println("Сегодня прошли больше чем вчера");
        } else if (stepsToday < stepsYesterday) {
            System.out.println("Сегодня прошли меньше чем вчера");
        } else {
            System.out.println("Вы прошли одинаковое количество шагов");
        }
        double average = (stepsYesterday + stepsToday) / 2.0;
        System.out.printf("Среднее: %.1f шагов", average);

        System.out.println("\n\n3. ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ");
        int guests = 15;
        if (guests < 0) {
            System.out.println("Ошибка: количество гостей не может быть отрицательным!");
        } else if (guests == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guests % 2 == 0) {
            System.out.println("Записалось " + guests + " гостей. Можно формировать пары для конкурсов.");
        } else {
            System.out.println("Записалось " + guests + " гостей. Нужны индивидуальные задания.");
        }

        System.out.println("\n4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");
        String nickname = "Xg8ig";
        char symbol = nickname.charAt(0);

        System.out.println("Способ 1 (проверка диапазона)");
        System.out.print("  Имя '" + nickname + "' начинается с ");
        if (symbol >= 'a' && symbol <= 'z') {
            System.out.println("маленькой буквы " + symbol);
        } else if (symbol >= 'A' && symbol <= 'Z') {
            System.out.println("большой буквы " + symbol);
        } else if (symbol >= '0' && symbol <= '9') {
            System.out.println("цифры " + symbol);
        } else {
            System.out.println("символа " + symbol);
        }

        System.out.println("\nСпособ 2 (методы Character)");
        System.out.print("  Имя " + "'" + nickname + "'" + " начинается с ");
        if (Character.isLowerCase(symbol)) {
            System.out.println("маленькой буквы " + symbol);
        } else if (Character.isUpperCase(symbol)) {
            System.out.println("большой буквы " + symbol);
        } else if (Character.isDigit(symbol)) {
            System.out.println("цифры " + symbol);
        } else {
            System.out.println("символа " + symbol);
        }

        System.out.println("\n5. ИНВЕНТАРИЗАЦИЯ");
        int dbSerial = 467;
        int pcSerial = 957;

        if (dbSerial == pcSerial) {
            System.out.print("[№" + pcSerial + "]: компьютер на 3-м этаже в кабинете 2");
        } else {
            boolean isEqual = (dbSerial % 10) == (pcSerial % 10);
            boolean isEqualTens = (dbSerial / 10 % 10) == (pcSerial / 10 % 10);
            boolean isEqualHundreds = (dbSerial / 100) == (pcSerial / 100);

            if (!isEqual && !isEqualTens && !isEqualHundreds) {
                System.out.print("[№" + pcSerial + "]: оборудование не идентифицировано");
            } else {
                System.out.printf("""
                        Нет полного совпадения:
                        База данных: [№%d]
                        Фактический: [№%s%s%s]""", dbSerial,
                        isEqualHundreds ? dbSerial % 10 : "_",
                        isEqualTens ? dbSerial / 10 % 10 : "_",
                        isEqual ? dbSerial / 100 : "_");
            }
        }
        System.out.println("\n\n6. ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        System.out.println("Способ 1 (float)");
        float deposit = 321123.79f;
        float interestRate = 0.1f;
        if (deposit < 100000) {
            interestRate = 0.05f;
        } else if (deposit <= 300000) {
            interestRate = 0.07f;
        }
        float interestAmount = deposit * interestRate;
        float totalAmount = deposit + interestAmount;
        System.out.println("Сумма вклада: " + deposit + " руб.");
        System.out.println("Сумма начисленного %: " + interestAmount + " руб.");
        System.out.println("Итоговая сумма с %: " + totalAmount + " руб.");

        System.out.println("\nСпособ 2 (BigDecimal)");
        BigDecimal depositBd = new BigDecimal("321123.79");
        BigDecimal interestRateBd = new BigDecimal("0.1");
        if (depositBd.compareTo(new BigDecimal("100000")) < 0) {
            interestRateBd = new BigDecimal("0.05");
        } else if (depositBd.compareTo(new BigDecimal("300000")) <= 0) {
            interestRateBd = new BigDecimal("0.07");
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
        int historyGrade = 2;

        if (historyPercent > 91) {
            historyGrade = 5;
        } else if (historyPercent > 73) {
            historyGrade = 4;
        } else {
            historyGrade = 3;
        }

        int programmingPercent = 92;
        int programmingGrade = 2;

        if (programmingPercent > 91) {
            programmingGrade = 5;
        } else if (programmingPercent > 73) {
            programmingGrade = 4;
        } else {
            programmingGrade = 3;
        }
        System.out.println("История" + ": " + historyGrade);
        System.out.println("Программирование" + ": " + programmingGrade);
        double averageGrade = (historyGrade + programmingGrade) / 2.0;
        double averagePercent = (historyPercent + programmingPercent) / 2.0;
        System.out.println("Средний балл: " + averageGrade);
        System.out.println("Средний %: " + averagePercent);

        System.out.println("\n8. РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ");
        BigDecimal monthlyRent = new BigDecimal("5123.018");
        BigDecimal monthlyCost = new BigDecimal("9001.729");
        BigDecimal monthlyRevenue = new BigDecimal("13025.233");

        BigDecimal profit1 = monthlyRevenue.subtract(monthlyCost)
                .subtract(monthlyRent)
                .multiply(BigDecimal.valueOf(12))
                .setScale(2, RoundingMode.HALF_DOWN);

        if (profit1.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("Прибыль за год: +" + profit1);
        } else {
            System.out.println("Прибыль за год: " + profit1);
        }
    }
}