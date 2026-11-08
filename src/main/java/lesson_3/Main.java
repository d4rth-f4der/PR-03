package lesson_3;

import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner, System.out);
        }
    }

    static void run(Scanner scanner, PrintStream out) {
        try {
            out.println("Введіть перше число (наприклад, 2.5):");
            double a = Double.parseDouble(scanner.nextLine().trim());

            out.println("Введіть друге число:");
            double b = Double.parseDouble(scanner.nextLine().trim());

            out.println("Виберіть операцію (+, -, *, /):");
            String operation = scanner.nextLine().trim();

            double result;
            switch (operation) {
                case "+":
                    result = Calculator.add(a, b);
                    break;
                case "-":
                    result = Calculator.subtract(a, b);
                    break;
                case "*":
                    result = Calculator.multiply(a, b);
                    break;
                case "/":
                    result = Calculator.divide(a, b);
                    break;
                default:
                    throw new InvalidInputException("Невідома операція. Виберіть +, -, * або /.");
            }

            out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            out.println("Помилка: введіть коректне число, наприклад 2.5.");
        } catch (ArithmeticException | InvalidInputException e) {
            out.println("Помилка: " + e.getMessage());
        } catch (NoSuchElementException e) {
            out.println("Помилка: потрібно ввести два числа й операцію.");
        } finally {
            out.println("Обробку запиту завершено.");
        }
    }
}
