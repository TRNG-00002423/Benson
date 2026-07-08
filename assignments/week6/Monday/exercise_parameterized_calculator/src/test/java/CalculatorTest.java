import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

public class CalculatorTest {
    private final Calculator calc = new Calculator();

    @ParameterizedTest()
    @ValueSource(ints = {2, 4, 12, 24})
    void isEven_testEvens_shouldReturnTrue(int num){
        assertTrue(calc.isEven(num));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "0, 0, 0",
        "-1, 1, 0",
        "100, 200, 300",
        "0, 1, 1",
        "0, -1, -1"
    })
    void add_variousInputs_returnsCorrectSum(int a, int b, int expected) {
        assertEquals(expected, calc.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, -1",
        "0, 0, 0",
        "-1, 1, -2",
        "100, 200, -100",
    })
    void subtract_variousInputs_returnsCorrectResult(int a, int b, int expected) {
        assertEquals(expected, calc.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 2",
        "0, 0, 0",
        "-1, 1, -1",
        "100, 200, 20000",
    })
    void multiply_variousInputs_returnsCorrectResult(int a, int b, int expected) {
        assertEquals(expected, calc.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 0",
        "2, 1, 2",
        "-1, 1, -1",
        "10, 5, 2",
    })
    void divide_variousInputs_returnsCorrectResult(int a, int b, int expected) {
        assertEquals(expected, calc.divide(a, b));
    }

    @ParameterizedTest
    @MethodSource("divisionTestCases")
    void divide_methodInputs_returnsCorrectResult(int a, int b, int res){
        assertEquals(res, calc.divide(a, b));
    }

    static Stream<Arguments> divisionTestCases(){
        return Stream.of(
            Arguments.of(8, 8, 1),
            Arguments.of(64, 8, 8),
            Arguments.of(81, 9, 9),
            Arguments.of(10, -5, -2)
        );
    }
}
