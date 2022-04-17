package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;

public class GameAnswerModel extends GameModel {

    public GameAnswerModel(int numberSize) {
        // 중복 제거를 위한 HashSet
        HashSet<Integer> set = new HashSet<>(numberSize);
        while (set.size() < numberSize) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        this.list.addAll(set);
    }

    public List<Integer> getAnswer() {
        return list;
    }
}
