import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    /**
     * "1,2"을 `,` 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * <p>
     * "1"을 `,` 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    void 요구사항1() {
        String temp1 = "1,2";
        String temp2 = "1";
        String[] tempArray1 = temp1.split(",");
        String[] tempArray2 = temp2.split(",");
        String[] expectArray = {"1", "2"};
        assertThat(tempArray1).containsExactly(expectArray); // 순서와 중복도 체크
        assertThat(tempArray2).contains("1");
    }

    /**
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    void 요구사항2() {
        String temp = "(1,2)";
        String testText = temp.substring(1, temp.length() - 1);
        String expectText = "1,2";
        assertThat(testText).isEqualTo(expectText);
    }

    /**
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * <p>
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는
     * 부분에 대한 학습 테스트를 구현한다.
     * <p>
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Test
    @DisplayName("요구사항3 : String의 charAt() 메소드를 활용한 테스트")
    void 요구사항3() {
        String temp = "abc";
        assertThat(temp.charAt(0)).isEqualTo('a');
        assertThat(temp.charAt(1)).isEqualTo('b');
        assertThat(temp.charAt(2)).isEqualTo('c');
        int length = temp.length();
        assertThatThrownBy(() -> temp.charAt(length))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining(String.format("String index out of range: %d", length));
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                temp.charAt(length);
            }).withMessageMatching(String.format("String index out of range: %d", length));
    }


    /**
     *
     */
    @Test
    @DisplayName("요구사항4 : String의 charAt() 메소드를 활용한 테스트")
    void 요구사항4() {

    }
}