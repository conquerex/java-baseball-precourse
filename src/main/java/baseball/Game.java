package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private final int NUMBER_COUNT = 3;
    private final String TEXT_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private final String TEXT_RESULT_STRIKE = "스트라이크";
    private final String TEXT_RESULT_BALL = "볼";
    private final String TEXT_RESULT_NOTHING = "낫싱";
    private final String TEXT_RESULT_CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private final String TEXT_RETRY_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String TEXT_GAME_OVER = "\n\n<<<<< GAME OVER >>>>>\n\n";

    List<Integer> answer = new ArrayList<>();

    void play() {
        makeAnswer();
        boolean isPlaying = true;
        while (isPlaying) {
            System.out.print(TEXT_INPUT_NUMBER);
            String playerInput = Console.readLine();
            List<Integer> input = getInputFromString(playerInput);
            int sCount = countStrike(input);
            int bCount = countBall(input);
            showStrikeAndBall(sCount, bCount);
            isNothing(sCount, bCount);
            isPlaying = !isGameOver(sCount);
        }
        retryOrExit();
    }

    void makeAnswer() {
        // 중복 제거를 위한 HashSet
        HashSet<Integer> set = new HashSet<>(NUMBER_COUNT);
        while (set.size() < NUMBER_COUNT) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        answer = new ArrayList<>(set);

        // todo : 확인용. 개발 이후 제거 예정
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    void retryOrExit() {
        System.out.println(TEXT_RETRY_OR_EXIT);
        String playerInput = Console.readLine();
        if (playerInput.equals("1")) {
            play();
            return;
        }
        if (playerInput.equals("2")) {
            System.out.println(TEXT_GAME_OVER);
            return;
        }
        throw new IllegalArgumentException();
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

    int countStrike(List<Integer> input) {
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

    int countBall(List<Integer> input) {
        int count = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            count = count + checkBall(answer.get(i), input.get(i));
        }
        return count;
    }

    int checkBall(int answerNumber, int inputNumber) {
        if (answerNumber != inputNumber && answer.contains(inputNumber)) {
            return 1;
        }
        return 0;
    }

    void showStrikeAndBall(int strike, int ball) {
        if (strike + ball == 0) {
            return;
        }
        if (strike == 0) {
            System.out.println(ball + TEXT_RESULT_BALL);
            return;
        }
        if (ball == 0 && strike < 3) {
            System.out.println(strike + TEXT_RESULT_STRIKE);
            return;
        }
        if (ball > 0 && strike > 0) {
            System.out.println(strike + TEXT_RESULT_STRIKE + ", " + ball + TEXT_RESULT_BALL);
        }
    }


    void isNothing(int strike, int ball) {
        if (strike + ball == 0) {
            System.out.println(TEXT_RESULT_NOTHING);
        }
    }

    boolean isGameOver(int strike) {
        if (strike == 3) {
            System.out.println(TEXT_RESULT_CORRECT);
            return true;
        }
        return false;
    }

}
