package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameAnswerModel {

    List<Integer> answer = new ArrayList<>();

    public GameAnswerModel(int numberSize) {
        // 중복 제거를 위한 HashSet
        HashSet<Integer> set = new HashSet<>(numberSize);
        while (set.size() < numberSize) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        this.answer.addAll(set);
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
}
