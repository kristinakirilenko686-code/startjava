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
        int guests = 15;
        if (guests == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guests % 2 == 0) {
            System.out.println("Записалось " + guests + " гостей. Можно формировать пары для конкурсов.");
        } else if (guests % 2 != 0) {
            System.out.println("Записалось " + guests + " гостей. Нужны индивидуальные задания.");
        } else if (guests < 0) {
            System.out.println("Ошибка: отрицательное количество гостей " + guests);
        }

        System.out.println("\n4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");
        String nickname = "Xg8ig";
        char Symbol = nickname.charAt(0);

        System.out.println("Способ 1 (проверка диапазона)");
        System.out.print("  Имя '" + nickname + "' начинается с ");
        if (Symbol >= 'a' && Symbol <= 'z') {
            System.out.println("маленькой буквы " + Symbol);
        } else if (Symbol >= 'A' && Symbol <= 'Z') {
            System.out.println("большой буквы " + Symbol);
        } else if (Symbol >= '0' && Symbol <= '9') {
            System.out.println("цифры " + Symbol);
        } else {
            System.out.println("символа " + Symbol);
        }

        System.out.println("\nСпособ 2 (методы Character)");
        System.out.print("  Имя " + "'" + nickname + "'" + " начинается с ");
        if (Character.isLowerCase(Symbol)) {
            System.out.println("маленькой буквы " + Symbol);
        } else if (Character.isUpperCase(Symbol)) {
            System.out.println("большой буквы " + Symbol);
        } else if (Character.isDigit(Symbol)) {
            System.out.println("цифры " + Symbol);
        } else {
            System.out.println("символа " + Symbol);
        }

        System.out.println("\n5. ИНВЕНТАРИЗАЦИЯ");
        int dbSeria = 467;
        int pcSerial = 957;

        if (dbSeria == pcSerial) {
            System.out.print("[№" + pcSerial + "]: компьютер на 3-м этаже в кабинете 2");
        } else {
            boolean isEqual = (dbSeria % 10) == (pcSerial % 10);
            boolean isEqualTens = (dbSeria / 10 % 10) == (pcSerial / 10 % 10);
            boolean isEqualHundreds = (dbSeria / 100) == (pcSerial / 100);

            if (!isEqual && !isEqualTens && !isEqualHundreds) {
                System.out.print("[№" + pcSerial + "]: оборудование не идентифицировано");
            } else {
                System.out.printf("""
                                Нет полного совпадения:
                                База данных: [№%d]
                                Фактический: [№%s%s%s]""", dbSeria,
                        isEqualHundreds ? dbSeria % 10 : "_",
                        isEqualTens ? dbSeria / 10 % 10 : "_",
                        isEqual ? dbSeria / 100 : "_");
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
        String subject1 = "История";
        int percent1 = 59;

        String subject2 = "Программирование";
        int percent2 = 92;

        int grade1;
        if (percent1 <= 60) {
            grade1 = 2;
        } else if (percent1 > 91) {
            grade1 = 5;
        } else if (percent1 > 73) {
            grade1 = 4;
        } else {
            grade1 = 3;
        }

        int grade2;
        if (percent2 <= 60) {
            grade2 = 2;
        } else if (percent2 > 91) {
            grade2 = 5;
        } else if (percent2 > 73) {
            grade2 = 4;
        } else {
            grade2 = 3;
        }
        System.out.println(subject1 + ": " + grade1);
        System.out.println(subject2 + ": " + grade2);
        double averageGrade = (grade1 + grade2) / 2.0;
        double averagePercent = (percent1 + percent2) / 2.0;
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