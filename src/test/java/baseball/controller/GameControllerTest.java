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

    GameController controller = new GameController();

    @BeforeEach
    void setUp() {
        controller.init();
    }

    @Test
    @DisplayName("생성된 정답, 자릿수 확인")
    void testGetNewAnswer() {
        List<Integer> newAnswer = controller.getNewAnswer();
        assertThat(newAnswer.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "플레이어 입력값 범위 밖의 경우 예외처리 [{index}] : {0}")
    @ValueSource(ints = {0, 1, 2, 9, 10})
    void testValidateValue(int number) {
        assertThatThrownBy(() -> controller.validateValue(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

}