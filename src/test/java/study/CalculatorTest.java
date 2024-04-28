package study;

import calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void calculate(String value) {
        String[] values = value.split(" ");
        int result = Calculator.calculate(values);
        Assertions.assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 +"})
    void 연산식이유효하지않으면오류가발생한다(String value) {
        String[] values = value.split(" ");
        assertThatThrownBy(
                () -> Calculator.calculate(values)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산식이 유효하지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 ) 3"})
    void 연산자가유효하지않으면오류가발생한다(String value) {
        String[] values = value.split(" ");
        assertThatThrownBy(
                () -> Calculator.calculate(values)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자가 유효하지 않습니다.");
    }
}
