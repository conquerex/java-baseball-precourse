package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private final int NUMBER_COUNT = 3;
    private final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    List<Integer> list = new ArrayList<>();

    Game() {
        // 중복 제거를 위한 HashSet
        HashSet<Integer> set = new HashSet<>(NUMBER_COUNT);
        while (set.size() < NUMBER_COUNT) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    void play() {
        //
    }

}
