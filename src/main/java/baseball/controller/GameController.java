package baseball.controller;

import static baseball.model.HintType.BALL;
import static baseball.model.HintType.STRIKE;

import baseball.model.GameAnswerModel;
import baseball.model.GameInputModel;
import baseball.model.HintType;
import java.util.List;

public class GameController {

    private final int NUMBER_COUNT = 3;
    private final int NUMBER_ASCII_1 = 49;
    private final int NUMBER_ASCII_9 = 57;
    private final String TEXT_RESULT_STRIKE = "스트라이크";
    private final String TEXT_RESULT_BALL = "볼 ";

    private GameAnswerModel answerModel;
    private GameInputModel inputModel;

    public void init() {
        answerModel = new GameAnswerModel(NUMBER_COUNT);
        inputModel = new GameInputModel();
    }

    public List<Integer> getAnswer() {
        return answerModel.getAnswer();
    }

    public void getInputFromString(String playerInput) {
        if (playerInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        inputModel.clear();
        for (int i = 0; i < playerInput.length(); i++) {
            validateValue(playerInput.charAt(i) - 0);
            inputModel.setInput(playerInput.charAt(i) - '0');
        }
    }

    public void validateValue(int value) {
        if (value < NUMBER_ASCII_1 || value > NUMBER_ASCII_9) {
            throw new IllegalArgumentException();
        }
    }

    public int countStrike() {
        int count = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            count = count + checkStrike(i);
        }
        return count;
    }

    private int checkStrike(int position) {
        if (answerModel.getValue(position) == inputModel.getValue(position)) {
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

    private int checkBall(int position) {
        if (answerModel.getValue(position) != inputModel.getValue(position)
            && answerModel.getAnswer().contains(inputModel.getValue(position))) {
            return 1;
        }
        return 0;
    }

    public String getHint(int strike, int ball) {
        return messageBuilder(BALL, ball) + messageBuilder(STRIKE, strike);
    }

    private String messageBuilder(HintType type, int count) {
        switch (type) {
            case STRIKE: return count + TEXT_RESULT_STRIKE;
            case BALL: return count + TEXT_RESULT_BALL;
        }
        return "";
    }

    public boolean isNothing(int sum) {
        if (sum == 0) return true;
        return false;
    }

    public boolean isGameOver(int strike) {
        if (strike == 3) return true;
        return false;
    }

}