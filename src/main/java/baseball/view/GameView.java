package baseball.view;

import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameView {

    private GameController controller = new GameController();

    private final String TEXT_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private final String TEXT_RESULT_NOTHING = "낫싱";
    private final String TEXT_RESULT_CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private final String TEXT_RETRY_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String TEXT_GAME_OVER = "게임 종료";
    private final String TEXT_AFTER_GAME_1 = "1";
    private final String TEXT_AFTER_GAME_2 = "2";

    public void start() {
        controller.init();
        List<Integer> answer = controller.getAnswer();
        boolean isPlaying = true;
        while (isPlaying) {
            isPlaying = playResult(answer);
        }
        System.out.println(TEXT_RESULT_CORRECT);
        System.out.println(TEXT_RETRY_OR_EXIT);
        retryOrExit();
    }

    private boolean playResult(List<Integer> answer) {
        System.out.print(TEXT_INPUT_NUMBER);
        controller.getInputFromString(Console.readLine());
        int sCount = controller.countStrike();
        int bCount = controller.countBall();
        if (controller.isNothing(sCount + bCount)) {
            System.out.println(TEXT_RESULT_NOTHING);
            return true;
        }
        System.out.println(controller.getHint(sCount, bCount));
        return !controller.isGameOver(sCount);
    }

    /**
     * 정답값 확인용
     */
    @Deprecated
    private void checkValue(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        System.out.println("\n");
    }

    private void retryOrExit() {
        String playerInput = Console.readLine();
        if (playerInput.equals(TEXT_AFTER_GAME_1)) {
            start();
            return;
        }
        if (playerInput.equals(TEXT_AFTER_GAME_2)) {
            System.out.println(TEXT_GAME_OVER);
            return;
        }
        throw new IllegalArgumentException();
    }

}
