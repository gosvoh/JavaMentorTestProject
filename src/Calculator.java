/*
 * Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b.
 * Данные передаются в одну строку (смотрите пример)! Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
 *
 * Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
 *
 * Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.
 *
 * Калькулятор умеет работать только с целыми числами.
 *
 * Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II
 * калькулятор должен выбросить исключениеи прекратить свою работу.
 *
 * При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе арабских - ответ ожидается арабскими.
 *
 * При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
 *
 * При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.
 */

import java.util.*;

/**
 * Калькулятор одной строки.<br>
 * Имеет 4 типа операций: сложение, вычитание, умножение и деление.<br>
 * Принимает числа только от 1 до 10 включительно.<br>
 * Умеет работать как с арабскими, так и с римскими цифрами.<br>
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            if (!scanner.hasNext())
                throw new RuntimeException("Вы ввели пустую строку, не надо так :(");
            // Разделяем полученную строку по ключевым символам (" ", "+", "-", "*" и "/"), оставляя их в массиве
            String[] input = scanner.nextLine().split("(?<=([ +\\-*/]))|(?=([ +\\-*/]))");
            // В голову пришёл только такой способ удаления не нужных нам пробелов
            List<String> list = new ArrayList<>(Arrays.asList(input));
            list.removeAll(Collections.singleton(" "));
            input = new String[list.size()];
            list.toArray(input);

            if (input.length != 3) throw new RuntimeException("Неизвестно что вы хотите сделать, не надо так :(");

            int val1, val2;
            String operation;

            // Флаг смены типа числа
            boolean isArabic = true;

            if (isInteger(input[0])) val1 = Integer.parseInt(input[0]);
            else {
                val1 = Nums.romanToArabic(input[0]);
                isArabic = false;
            }

            operation = input[1];

            if (isInteger(input[2])) {
                if (!isArabic) throw new RuntimeException("Вы ввели разные типы чисел, не надо так :(");
                val2 = Integer.parseInt(input[2]);
            } else {
                if (isArabic) throw new RuntimeException("Вы ввели разные типы чисел, не надо так :(");
                val2 = Nums.romanToArabic(input[2]);
            }

            if (val1 < 1 || val1 > 10 || val2 < 1 || val2 > 10)
                throw new RuntimeException("Числа должны быть от 1 до 10 включительно!");

            int result = CalculationProcess.getCalculationResult(val1, val2, operation);
            if (isArabic) System.out.println(result);
            else System.out.println(Nums.arabicToRoman(result));
        }

    }

    /**
     * Является ли переданное значение целочисленным числом в арабском виде
     *
     * @param val строка для проверки
     * @return true, если является
     */
    public static boolean isInteger(String val) {
        boolean ret = true;
        try {
            Integer.parseInt(val);
        } catch (NumberFormatException ex) {
            ret = false;
        }

        return ret;
    }
}
