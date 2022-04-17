package baseball.controller;

import baseball.model.GameAnswerModel;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final int NUMBER_COUNT = 3;
    private final String TEXT_RESULT_STRIKE = "스트라이크";
    private final String TEXT_RESULT_BALL = "볼 ";

    GameAnswerModel answerModel;

    public List<Integer> getNewAnswer() {
        answerModel = new GameAnswerModel(NUMBER_COUNT);
        return answerModel.getAnswer();
    }

    public List<Integer> getInputFromString(String playerInput) {
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < playerInput.length(); i++) {
            input.add(playerInput.charAt(i) - '0');
        }
        return input;
    }

    public int countStrike(List<Integer> input) {
        int count = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            count = count + checkStrike(answerModel.getAnswer().get(i), input.get(i));
        }
        return count;
    }

    int checkStrike(int answerNumber, int inputNumber) {
        if (answerNumber == inputNumber) {
            return 1;
        }
        return 0;
    }

    public int countBall(List<Integer> input) {
        int count = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            count = count + checkBall(answerModel.getAnswer().get(i), input.get(i));
        }
        return count;
    }

    int checkBall(int answerNumber, int inputNumber) {
        if (answerNumber != inputNumber && answerModel.getAnswer().contains(inputNumber)) {
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
