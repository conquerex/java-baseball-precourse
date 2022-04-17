package baseball.controller;

import baseball.model.GameAnswerModel;
import baseball.model.GameInputModel;
import java.util.List;

public class GameController {

    private final int NUMBER_COUNT = 3;
    private final String TEXT_RESULT_STRIKE = "스트라이크";
    private final String TEXT_RESULT_BALL = "볼 ";

    GameAnswerModel answerModel;
    GameInputModel inputModel;

    public void init() {
        answerModel = new GameAnswerModel(NUMBER_COUNT);
        inputModel = new GameInputModel();
    }

    public List<Integer> getNewAnswer() {
        return answerModel.getAnswer();
    }

    public List<Integer> getInputFromString(String playerInput) {
        inputModel.clear();
        for (int i = 0; i < playerInput.length(); i++) {
            inputModel.setInput(playerInput.charAt(i) - '0');
        }
        return inputModel.getInput();
    }

    public int countStrike() {
        int count = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            count = count + checkStrike(i);
        }
        return count;
    }

    int checkStrike(int position) {
        if (answerModel.getAnswer().get(position).equals(inputModel.getInput().get(position))) {
            return 1;
        }
        return 0;
    }

    public int countBall() {
        int count = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            count = count + checkBall(i);
        }
        return count;
    }

    int checkBall(int position) {
        if (!answerModel.getAnswer().get(position).equals(inputModel.getInput().get(position))
            && answerModel.getAnswer().contains(inputModel.getInput().get(position))) {
            return 1;
        }
        return 0;
    }

    public String getHint(int strike, int ball) {
        return getBallMessage(ball) + getStrikeMessage(strike);
    }

    String getStrikeMessage(int strike) {
        if (strike > 0) {
            return strike + TEXT_RESULT_STRIKE;
        }
        return "";
    }

    String getBallMessage(int ball) {
        if (ball > 0) {
            return ball + TEXT_RESULT_BALL;
        }
        return "";
    }

}
