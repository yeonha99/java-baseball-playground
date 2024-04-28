package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String targetString = "(1,2)";
        int startIndex = targetString.indexOf("(") + 1;
        int endIndex = targetString.indexOf(")");
        String actual = targetString.substring(startIndex, endIndex);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException가 발생한다.")
    void chatAt() {
        String targetString = "abc";
        assertThatThrownBy(
                () -> targetString.charAt(targetString.length())
        ).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
