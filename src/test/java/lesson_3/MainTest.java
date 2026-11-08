package lesson_3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    @Test
    void printsResultAndCompletion() {
        String output = runWithInput("7.5\n2.5\n/\n");

        assertTrue(output.contains("Результат: 3.0"), output);
        assertTrue(output.endsWith("Обробку запиту завершено." + System.lineSeparator()), output);
    }

    @Test
    void reportsInvalidNumberAndCompletion() {
        String output = runWithInput("abc\n2\n+\n");

        assertTrue(output.contains("Помилка: введіть коректне число"), output);
        assertTrue(output.endsWith("Обробку запиту завершено." + System.lineSeparator()), output);
    }

    @Test
    void reportsDivisionByZero() {
        String output = runWithInput("5\n0\n/\n");

        assertTrue(output.contains("Помилка: Ділити на нуль не можна."), output);
    }

    @Test
    void reportsUnknownOperation() {
        String output = runWithInput("5\n2\n%\n");

        assertTrue(output.contains("Помилка: Невідома операція."), output);
    }

    @Test
    void reportsIncompleteInput() {
        String output = runWithInput("5\n");

        assertTrue(output.contains("Помилка: потрібно ввести два числа й операцію."), output);
    }

    private static String runWithInput(String input) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (Scanner scanner = new Scanner(input);
             PrintStream out = new PrintStream(output, true, StandardCharsets.UTF_8)) {
            Main.run(scanner, out);
        }
        return output.toString(StandardCharsets.UTF_8);
    }
}
