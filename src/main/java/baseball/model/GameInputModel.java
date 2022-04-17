package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class GameInputModel {

    List<Integer> input = new ArrayList<>();

    public List<Integer> getInput() {
        return input;
    }

    public void setInput(Integer input) {
        this.input.add(input);
    }

    public void clear() {
        this.input.clear();
    }
}
