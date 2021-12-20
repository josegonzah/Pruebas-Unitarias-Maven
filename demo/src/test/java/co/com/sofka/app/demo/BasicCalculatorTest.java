package co.com.sofka.app.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import co.com.sofka.app.calculator.BasicCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorTest {

    /* Sujeto de prueba */
    private final BasicCalculator basiCalculator = new BasicCalculator();

    /* Un solo caso de entrada */

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        /* Arrange */
        Long number1 = 1L;
        Long number2 = 1L;

        Long expectedValue = 2L;

        /* Act */
        Long result = basiCalculator.sum(number1, number2);

        /* Assert */
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing res: 2-1=1")
    public void res() {
        /* Arrange */
        Long number1 = 2L;
        Long number2 = 1L;

        Long expectedValue = 1L;

        /* Act */
        Long result = basiCalculator.min(number1, number2);

        /* Assert */
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing mult: 2*2=4")
    public void mult() {
        /* Arrange */
        Long number1 = 2L;
        Long number2 = 2L;

        Long expectedValue = 4L;

        /* Act */
        Long result = basiCalculator.mult(number1, number2);

        /* Assert */
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing div: 4/2=2")
    public void div() {
        /* Arrange */
        Long number1 = 4L;
        Long number2 = 2L;

        Long expectedValue = 2L;

        /* Act */
        Long result = basiCalculator.div(number1, number2);

        /* Assert */
        assertEquals(expectedValue, result);
    }

    /* Múltiples casos de entrada */

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0, 1, 1",
            "1, 2, 3",
            "49, 51, 100",
            "1, 100, 101",
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basiCalculator.sum(first, second),() -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several subtractions")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0, 1, -1",
            "1, 2, -1",
            "49, 51, -2",
            "1, 100, -99",
    })
    public void severalRests(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basiCalculator.res(first, second),() -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several multiplications")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "0, 1, 0",
            "1, 2, 2",
            "49, 51, 2499",
            "1, 100, 100",
    })
    public void severalMults(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basiCalculator.mult(first, second),() -> first + " * " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several Divisions")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "0, 1, 0",
            "1, 2, 0,5",
            "49, 51, 0,9608",
            "1, 100, 0,01",
    })
    public void severalDivs(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basiCalculator.div(first, second),() -> first + " / " + second + " should equal " + expectedResult);
    }

}