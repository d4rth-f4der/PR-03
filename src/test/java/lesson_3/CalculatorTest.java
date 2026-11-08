package lesson_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private static final double DELTA = 1e-9;

    @Test
    void addsFractionalNumbers() throws InvalidInputException {
        assertEquals(0.3, Calculator.add(0.1, 0.2), DELTA);
    }

    @Test
    void subtractsNumbers() throws InvalidInputException {
        assertEquals(-2.5, Calculator.subtract(1.5, 4.0), DELTA);
    }

    @Test
    void multipliesNegativeNumber() throws InvalidInputException {
        assertEquals(-6.0, Calculator.multiply(-2.0, 3.0), DELTA);
    }

    @Test
    void dividesNumbers() throws InvalidInputException {
        assertEquals(3.0, Calculator.divide(7.5, 2.5), DELTA);
    }

    @Test
    void rejectsZeroDivisor() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5.0, 0.0));
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5.0, -0.0));
    }

    @Test
    void rejectsNonFiniteOperands() {
        assertThrows(InvalidInputException.class, () -> Calculator.add(Double.NaN, 1.0));
        assertThrows(InvalidInputException.class, () -> Calculator.multiply(1.0, Double.POSITIVE_INFINITY));
    }
}
