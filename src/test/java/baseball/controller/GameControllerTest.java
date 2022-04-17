package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameControllerTest {

    private final int COUNT_MAX = 3;
    private final int COUNT_MIN = 0;

    GameController controller = new GameController();

    @BeforeEach
    void setUp() {
        controller.init();
    }

    @Test
    @DisplayName("정답값 자릿수 확인")
    void testGetAnswer() {
        List<Integer> newAnswer = controller.getAnswer();
        assertThat(newAnswer.size()).isEqualTo(COUNT_MAX);
    }

    @ParameterizedTest(name = "입력값 길이 체크 - 예외처리 [{index}] : {0}")
    @ValueSource(strings = {"1", "23", "5678"})
    void testGetInputFromString(String playerInput) {
        assertThatThrownBy(() -> controller.getInputFromString(playerInput))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "입력 아스키코드값 범위 체크 - 예외처리 [{index}] : {0}")
    @ValueSource(chars = {'0', 'a', '가', '$'})
    void testValidateValue(char text) {
        assertThatThrownBy(() -> controller.validateValue(text - 0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "볼 & 스트라이크 갯수 체크 - 예외처리 [{index}] : {0}")
    @ValueSource(strings = {"123", "456", "987", "248"})
    void testCountStrikeAndBall(String numText) {
        controller.getInputFromString(numText);
        assertThat(controller.countStrike()).isLessThan(COUNT_MAX + 1);
        assertThat(controller.countBall()).isLessThan(COUNT_MAX + 1);
        assertThat(controller.countStrike()).isGreaterThan(COUNT_MIN - 1);
        assertThat(controller.countBall()).isGreaterThan(COUNT_MIN - 1);
    }

    @Test
    @DisplayName("볼 & 스트라이크 메세지 체크")
    void testGetHint() {
        String[] typeArray = {"볼", "스트라이크"};
        String message = controller.getHint(1, 2);
        String[] array = message.split(" ");
        for (int i = 0; i < array.length; i++) {
            assertThat(typeArray).contains(array[i].substring(1));
        }
    }

    @Test
    @DisplayName("낫싱 체크")
    void testIsNothing() {
        assertThat(controller.isNothing(0)).isTrue();
        assertThat(controller.isNothing(1)).isFalse();
    }

    @Test
    @DisplayName("게임 종료 체크")
    void testIsGameOver() {
        assertThat(controller.isGameOver(3)).isTrue();
        assertThat(controller.isGameOver(2)).isFalse();
    }
}