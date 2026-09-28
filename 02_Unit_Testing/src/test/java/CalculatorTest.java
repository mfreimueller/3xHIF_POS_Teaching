import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void setUp()  {
        calculator = new Calculator();
    }

    // test the happy path
    @Test
    void ensureThatDivideProperlyDividesTwoNumbers() {
        // arrange

        // act
        assertEquals(10, calculator.divide(100, 10));

//        var result = calculator.divide(100, 10);
//
//        // assert
//        assertEquals(10, result);
    }

    @Test
    void ensureThatDividingByZeroFails() {
        // arrange

        // act
        assertThrows(ArithmeticException.class, () -> calculator.divide(100, 0));
    }
}