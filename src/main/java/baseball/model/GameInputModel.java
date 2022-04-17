package baseball.model;

import java.util.List;

public class GameInputModel extends GameModel {

    public List<Integer> getInput() {
        return list;
    }

    public void setInput(Integer input) {
        this.list.add(input);
    }

    public void clear() {
        this.list.clear();
    }
}
