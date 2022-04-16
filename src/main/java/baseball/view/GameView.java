package baseball.view;

import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameView {

    private GameController controller = new GameController();

    private final String TEXT_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private final String TEXT_RESULT_NOTHING = "낫싱";
    private final String TEXT_RESULT_CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private final String TEXT_RETRY_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String TEXT_GAME_OVER = "\n\n<<<<< GAME OVER >>>>>\n\n";

    List<Integer> answer = new ArrayList<>();

    public void start() {
        answer = controller.getAnswer();
        checkValue(answer);
        boolean isPlaying = true;
        while (isPlaying) {
            isPlaying = playResult();
        }
        System.out.println(TEXT_RETRY_OR_EXIT);
        retryOrExit();
    }

    boolean playResult() {
        System.out.print(TEXT_INPUT_NUMBER);
        String playerInput = Console.readLine();
        List<Integer> input = controller.getInputFromString(playerInput);
        checkValue(input);
        int sCount = controller.countStrike(answer, input);
        int bCount = controller.countBall(answer, input);
        if (isNothing(sCount, bCount)) return true;
        System.out.println(controller.getHint(sCount, bCount));
        return !isGameOver(sCount);
    }

    // todo : 확인용. 개발 이후 제거 예정
    @Deprecated
    void checkValue(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    void retryOrExit() {
        String playerInput = Console.readLine();
        if (playerInput.equals("1")) {
            start();
            return;
        }
        if (playerInput.equals("2")) {
            System.out.println(TEXT_GAME_OVER);
            return;
        }
        throw new IllegalArgumentException();
    }

    boolean isNothing(int strike, int ball) {
        if (strike + ball == 0) {
            System.out.println(TEXT_RESULT_NOTHING);
            return true;
        }
        return false;
    }

    boolean isGameOver(int strike) {
        if (strike == 3) {
            System.out.println(TEXT_RESULT_CORRECT);
            return true;
        }
        return false;
    }

}
