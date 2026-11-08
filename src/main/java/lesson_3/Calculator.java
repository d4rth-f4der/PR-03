package lesson_3;

public class Calculator {
    public static double add(double a, double b) throws InvalidInputException {
        validateOperands(a, b);
        return a + b;
    }

    public static double subtract(double a, double b) throws InvalidInputException {
        validateOperands(a, b);
        return a - b;
    }

    public static double multiply(double a, double b) throws InvalidInputException {
        validateOperands(a, b);
        return a * b;
    }

    public static double divide(double a, double b) throws InvalidInputException {
        validateOperands(a, b);
        if (b == 0.0) {
            throw new ArithmeticException("Ділити на нуль не можна.");
        }
        return a / b;
    }

    private static void validateOperands(double a, double b) throws InvalidInputException {
        if (!Double.isFinite(a) || !Double.isFinite(b)) {
            throw new InvalidInputException("Обидва числа мають бути скінченними.");
        }
    }
}
