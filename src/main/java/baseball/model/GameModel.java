package baseball.model;

import java.util.ArrayList;
import java.util.List;

public abstract class GameModel {
    public List<Integer> list = new ArrayList<>();

    public int getValue(int position) {
        return list.get(position);
    }
}
