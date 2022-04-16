package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameController {

    private final int NUMBER_COUNT = 3;
    private final String TEXT_RESULT_STRIKE = "스트라이크";
    private final String TEXT_RESULT_BALL = "볼 ";

    ArrayList<Integer> getAnswer() {
        // 중복 제거를 위한 HashSet
        HashSet<Integer> set = new HashSet<>(NUMBER_COUNT);
        while (set.size() < NUMBER_COUNT) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        return new ArrayList<>(set);
    }

    List<Integer> getInputFromString(String playerInput) {
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < playerInput.length(); i++) {
            input.add(playerInput.charAt(i) - '0');
        }

        // todo : 확인용. 개발 이후 제거 예정
        for (int i = 0; i < input.size(); i++) {
            System.out.println(input.get(i));
        }

        return input;
    }

    int countStrike(List<Integer> answer, List<Integer> input) {
        int count = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            count = count + checkStrike(answer.get(i), input.get(i));
        }
        return count;
    }

    int checkStrike(int answerNumber, int inputNumber) {
        if (answerNumber == inputNumber) {
            return 1;
        }
        return 0;
    }

    int countBall(List<Integer> answer, List<Integer> input) {
        int count = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            count = count + checkBall(answer, answer.get(i), input.get(i));
        }
        return count;
    }

    int checkBall(List<Integer> answer, int answerNumber, int inputNumber) {
        if (answerNumber != inputNumber && answer.contains(inputNumber)) {
            return 1;
        }
        return 0;
    }

    String getHint(int strike, int ball) {
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
