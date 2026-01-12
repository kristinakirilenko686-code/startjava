void main() {

    IO.println("1. ВЫВОД ASCII-ГРАФИКИ");
    IO.println("Способ 1");
    IO.println(
            """
                                         /\\\
                    
                       J    a  v     v  /  \\\
                    
                       J   a a  v   v  /_( )\\\
                    
                    J  J  aaaaa  V V  /      \\\
                    
                     JJ  a     a  V  /___/\\___\\
                    """);

    IO.println("Способ 2 (Text block)");
    IO.println("""
                     /\\
               J    /  \\  v     v  a
               J   /_( )\\  v   v  a a
            J  J  /      \\  V V  aaaaa
             JJ  /___/\\___\\  V  a     a""");

    IO.println();
    IO.println("РАСЧЕТ СТОИМОСТИ ТОВАРА");

    IO.println("Способ 1 (float)");
    float penPrice = 105.5f;
    float bookPrice = 235.23f;
    float discount = 0.11f;

    float basePrice = penPrice + bookPrice;
    float discountSum = basePrice * discount;


    IO.println("  Стоимость товаров без скидки: " + basePrice + " руб.");
    IO.println("  Сумма скидки: " + discountSum + " руб.");
    IO.println("  Стоимость товаров со скидкой: " + (basePrice - discountSum) + " руб.");

    IO.println();
    IO.println("Способ 2 (BigDecimal)");

    BigDecimal penPriceBd = new BigDecimal("105.5");
    BigDecimal bookPriceBd = new BigDecimal("235.83");
    BigDecimal discountBd = new BigDecimal("0.11");

    BigDecimal basePriceBd = penPriceBd.add(bookPriceBd).setScale(2, RoundingMode.HALF_DOWN);
    BigDecimal discountSumBd = basePriceBd.multiply(discountBd).setScale(2, RoundingMode.HALF_DOWN);
    BigDecimal discountPriceBd = basePriceBd.subtract(discountSumBd).setScale(2, RoundingMode.HALF_DOWN);

    IO.println("  Стоимость товаров без скидки: " + basePriceBd + " руб.");
    IO.println("  Сумма скидки: " + discountSumBd + " руб.");
    IO.println("  Стоимость товаров со скидкой: " + discountPriceBd + " руб.");

    IO.println();

    IO.println("3. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");

    int a = 2;
    int b = 5;

    IO.println("  Исходные значения: A = " + a + ", B = " + b);
    IO.println("Метод: третья переменная");
    int swap = a;
    a = b;
    b = swap;
    IO.println("  Результат: A = " + a + ", B1 = " + b);

    IO.println("Метод: арифметические операции");
    a += b;
    b = a - b;
    a -= b;
    IO.println("  Результат: A = " + a + ", B = " + b);

    IO.println("Метод: побитовая операция ^");
    a ^= b;
    b ^= a;
    a ^= b;
    IO.println("  Результат: A = " + a + ", B = " + b);

    IO.println();
    IO.println("\n4. ДЕКОДИРОВАНИЕ СООБЩЕНИЯ");
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

    IO.println();
    IO.println("\n5. АНАЛИЗ КОДА ТОВАРА");
    int productCode = 123;
    int category = productCode / 100;
    int subcategory = productCode / 10 % 10;
    int packageType = productCode % 10;

    IO.println("Код товара: " + productCode +
            "\n  категория товара - " + category +
            "\n  подкатегория - " + subcategory +
            "\n  тип упаковки - " + packageType +
            "\nКонтрольная сумма = " + (category + subcategory + packageType) +
            "\nПроверочный код = " + (category * subcategory * packageType));

    IO.println();

    IO.println("6. ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ");
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

    IO.println();
    IO.println("ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА");

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    long startNanos = System.nanoTime();
    LocalTime startTime = LocalTime.now();
    try {
        Thread.sleep(59);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    long endNanos = System.nanoTime();
    LocalTime endTime = LocalTime.now();

    double elapsedSeconds = (endNanos - startNanos) / 1_000_000_000.0;
    String formattedTime = String.format("%.3f", elapsedSeconds).replace('.', ',');
    System.out.printf("""
                    | Старт проверки | %s |
                    +----------------+--------------+
                    | Финиш проверки | %s |
                    +----------------+--------------+
                    | Время работы   | %s сек    |
                    """,
            dtf.format(startTime),
            dtf.format(endTime),
            formattedTime
    );


}






