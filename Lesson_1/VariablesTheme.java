package Lesson_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VariablesTheme {
    static void main() {
        final LocalTime startTime = LocalTime.now();
        final long startNanos = System.nanoTime();

        System.out.println("\n1. ВЫВОД ASCII-ГРАФИКИ");
        System.out.println("Способ 1 (String.join())");
        System.out.println(String.join("\n",
                "                     /\\",
                "   J    a  v     v  /  \\",
                "   J   a a  v   v  /_( )\\",
                "J  J  aaaaa  V V  /      \\",
                " JJ  a     a  V  /___/\\___\\"));

        System.out.println("\nСпособ 2 (Text block)");
        System.out.println("""
                         /\\
                   J    /  \\  v     v  a
                   J   /_( )\\  v   v  a a
                J  J  /      \\  V V  aaaaa
                 JJ  /___/\\___\\  V  a     a""");

        System.out.println("\n2. РАСЧЕТ СТОИМОСТИ ТОВАРА");
        System.out.println("Способ 1 (float)");
        float penPrice = 105.5f;
        float bookPrice = 235.23f;
        float discount = 0.11f;

        float basePrice = penPrice + bookPrice;
        float discountSum = basePrice * discount;

        System.out.println("  Стоимость товаров без скидки: " + basePrice + " руб.");
        System.out.println("  Сумма скидки: " + discountSum + " руб.");
        System.out.println("  Стоимость товаров со скидкой: " + (basePrice - discountSum) + " руб.");

        System.out.println("\nСпособ 2 (BigDecimal)");

        BigDecimal penPriceBd = new BigDecimal("105.5");
        BigDecimal bookPriceBd = new BigDecimal("235.83");
        BigDecimal discountBd = new BigDecimal("0.11");

        BigDecimal basePriceBd = penPriceBd.add(bookPriceBd).setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal discountSumBd = basePriceBd.multiply(discountBd).setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal discountPriceBd = basePriceBd.subtract(discountSumBd).setScale(2, RoundingMode.HALF_DOWN);

        System.out.println("  Стоимость товаров без скидки: " + basePriceBd + " руб.");
        System.out.println("  Сумма скидки: " + discountSumBd + " руб.");
        System.out.println("  Стоимость товаров со скидкой: " + discountPriceBd + " руб.");

        System.out.println("\n3. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");
        int a = 2;
        int b = 5;

        System.out.println("  Исходные значения: A = " + a + ", B = " + b);
        System.out.println("\nМетод: третья переменная");
        int swap = a;
        a = b;
        b = swap;
        System.out.println("  Результат: A = " + a + ", B = " + b);

        System.out.println("\nМетод: арифметические операции");
        a += b;
        b = a - b;
        a -= b;
        System.out.println("  Результат: A = " + a + ", B = " + b);

        System.out.println("\nМетод: побитовая операция ^");
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("  Результат: A = " + a + ", B = " + b);

        System.out.println("\n4. ДЕКОДИРОВАНИЕ СООБЩЕНИЯ");
        int code1055 = 1055;
        int code1088 = 1088;
        int code1080 = 1080;
        int code1074 = 1074;
        int code1077 = 1077;
        int code1090 = 1090;
        System.out.printf("%5d%5d%5d%5d%5d%5d%n",
                code1055, code1088, code1080, code1074, code1077, code1090);
        System.out.printf("%5c%5c%5c%5c%5c%5c%n",
                code1055, code1088, code1080, code1074, code1077, code1090);

        System.out.println("\n5. АНАЛИЗ КОДА ТОВАРА");
        int productCode = 123;
        int category = productCode / 100;
        int subcategory = productCode / 10 % 10;
        int packageType = productCode % 10;

        System.out.println("Код товара: " + productCode +
                "\n  категория товара - " + category +
                "\n  подкатегория - " + subcategory +
                "\n  тип упаковки - " + packageType +
                "\nКонтрольная сумма = " + (category + subcategory + packageType) +
                "\nПроверочный код = " + (category * subcategory * packageType));

        System.out.println("\n6. ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ");
        byte temp = Byte.MAX_VALUE;
        System.out.printf("""
                [Температура, °C]:
                  Исходное: %d
                  +1: %d
                  -1: %d%n
                """, temp, ++temp, --temp);

        short pressure = Short.MAX_VALUE;
        System.out.printf("""
                [Давление, kPa]:
                  Исходное: %d
                  +1: %d
                  -1: %d%n
                """, pressure, ++pressure, --pressure);

        char systemStateCode = Character.MAX_VALUE;
        System.out.printf("""
                [Код состояния системы]:
                  Исходное: %d
                  +1: %d
                  -1: %d%n
                """, (int) systemStateCode, (int) ++systemStateCode, (int) --systemStateCode);

        int distanceCovered = Integer.MAX_VALUE;
        System.out.printf("""
                [Пройденное расстояние, pc]:
                  Исходное: %d
                  +1: %d
                  -1: %d%n
                """, distanceCovered, ++distanceCovered, --distanceCovered);

        long missionElapsedTime = Long.MAX_VALUE;
        System.out.printf("""       
                [Время с момента старта, DDD]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """, missionElapsedTime, ++missionElapsedTime, --missionElapsedTime);

        System.out.println("\n7. ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        double duration = (System.nanoTime() - startNanos) / 1e9;
        System.out.println("| Старт проверки | " + formatter.format(startTime) + " |");
        System.out.println("+----------------+--------------+");
        System.out.println("| Финиш проверки | " +  formatter.format(LocalTime.now()) + " |");
        System.out.println("+----------------+--------------+");
        System.out.println("| Время работы   | " + duration + " сек    |");
    }
}






