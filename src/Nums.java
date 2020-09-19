import java.util.Map;
import java.util.TreeMap;

/**
 * Утилитный класс для перевода арабского числа в римское и обратно
 */
public final class Nums {

    /**
     * TreeMap для хранения арабских чисел и их римского эквивалента в виде строки
     */
    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
    }

    /**
     * @param value арабское число
     * @return римское число
     */
    public static String arabicToRoman(int value) {
        int l = map.floorKey(value);
        if (value == l) return map.get(value);
        return map.get(l) + arabicToRoman(value - l);
    }

    /**
     * @param value рисмкое число
     * @return арабское число
     */
    public static int romanToArabic(String value) {
        if (value.length() == 0) throw new NumberFormatException("An empty string does not define a Roman numeral.");

        value = value.toUpperCase();

        int iterator = 0;
        int result = 0;

        while (iterator < value.length()) {

            char letter = value.charAt(iterator);
            int number = map.entrySet()
                    .stream()
                    .filter(entry -> letter == entry.getValue().charAt(0))
                    .map(Map.Entry::getKey).findFirst().get();

            ++iterator;

            if (iterator == value.length()) result += number;
            else {
                char nextLetter = value.charAt(iterator);
                int nextNumber = map.entrySet()
                        .stream()
                        .filter(entry -> nextLetter == entry.getValue().charAt(0))
                        .map(Map.Entry::getKey).findFirst().get();
                if (nextNumber > number) {
                    result += (nextNumber - number);
                    iterator++;
                } else result += number;
            }
        }
        return result;
    }
}
