/**
 * Абстрактный класс с единственным методом для вычисления ответа
 */
public abstract class CalculationProcess {

    /**
     * Вычислить ответ из переданных аргументов
     * @param value1 первое число
     * @param value2 второе число
     * @param operation операция
     * @return ответ
     * @throws ArithmeticException если введена не верная операция
     */
    public static int getCalculationResult(int value1, int value2, String operation) {
        int result;
        switch (operation) {
            case "+" -> result = value1 + value2;
            case "-" -> result = value1 - value2;
            case "*" -> result = value1 * value2;
            case "/" -> result = value1 / value2;
            default -> throw new ArithmeticException("Вы ввели неизвестную операцию, не надо так :(");
        }

        return result;
    }
}
