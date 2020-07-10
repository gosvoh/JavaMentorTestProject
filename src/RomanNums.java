import java.util.Arrays;

/**
 * Перечисление всех римских цифр.
 * Один из самых примитивных способов решения задачи.
 */
public enum RomanNums {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10);

    /**
     * Целочисленное представление римской цифры в виде арабской цифры
     */
    private final int value;

    /**
     * Конструктор с аргументом в виде целого числа для связывания элемента перечисления и числа
     *
     * @param value целое число
     */
    RomanNums(int value) {
        this.value = value;
    }

    /**
     * Получить целочисленное представление римской цифры в виде арабской цифры
     *
     * @param value риская цифра
     * @return арабская цифра
     * @throws RuntimeException если было введено не целое, не римское число, оно меньше 1 или больше 10
     */
    public static int romanToArabic(String value) {
        final int[] result = {0};

        Arrays.stream(values()).filter(v -> value.equalsIgnoreCase(String.valueOf(v))).forEach(v -> result[0] = v.value);

        if (result[0] == 0)
            throw new RuntimeException("Вы ввели некорректное число, не надо так :(");

        return result[0];
    }
}
