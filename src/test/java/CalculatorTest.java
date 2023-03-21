import calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    private static final double DELTA = 1e-15;

    @Test
    public void squareRootTestValidValues() {
        assertEquals("Square Root Test 1", 2, calculator.squareRoot(4), DELTA);
        assertEquals("Square Root Test 2", 0, calculator.squareRoot(0), DELTA);
        assertEquals("Square Root Test 3", 9, calculator.squareRoot(81), DELTA);
        assertEquals("Square Root Test 4", 1.4142135623730951, calculator.squareRoot(2), DELTA);
    }

    @Test
    public void squareRootTestInvalidValues() {
        assertEquals("Square Root Test 1", -1, calculator.squareRoot(-5), DELTA);
        assertEquals("Square Root Test 2", -1, calculator.squareRoot(-2.788), DELTA);
    }

    @Test
    public void factorialTestValidValues() {
        assertEquals("factorial Test 1", 1, calculator.factorial(0), DELTA);
        assertEquals("factorial Test 2", 1, calculator.factorial(1), DELTA);
        assertEquals("factorial Test 3", 2, calculator.factorial(2), DELTA);
        assertEquals("factorial Test 4", 6, calculator.factorial(3), DELTA);
    }

    @Test
    public void factorialTestInvalidValues() {
        // should return the error code -1
        assertEquals("factorial Test 1", -1, calculator.factorial(-1), DELTA);
        assertEquals("factorial Test 2", -1, calculator.factorial(-4), DELTA);
    }

    @Test
    public void logTestValidValues() {
        assertEquals("Log Test 1", 2.302585092994046, calculator.naturalLog(10), DELTA);
        assertEquals("Log Test 2", 4.605170185988092, calculator.naturalLog(100), DELTA);
        assertEquals("Log Test 3", 0, calculator.naturalLog(1), DELTA);
        assertEquals("Log Test 4", 1.91530365531951, calculator.naturalLog(6.789), DELTA);
    }

    @Test
    public void logTestInvalidValues() {
        assertEquals("Log Test 1", -1, calculator.naturalLog(-4), DELTA);
        assertEquals("Log Test 2", -1, calculator.naturalLog(-13.45), DELTA);
        assertEquals("Log Test 3", -1, calculator.naturalLog(0), DELTA);
    }

    @Test
    public void powerTestValidValues() {
        assertEquals("Power Test 1", 4, calculator.Power(2, 2), DELTA);
        assertEquals("Power Test 2", 125, calculator.Power(5, 3), DELTA);
        assertEquals("Power Test 3", 3, calculator.Power(3, 1), DELTA);
        assertEquals("Power Test 4", 1, calculator.Power(10, 0), DELTA);
    }
}
