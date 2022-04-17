package baseball.model;

public class GameInputModel extends GameModel {

    public void setInput(Integer input) {
        this.list.add(input);
    }

    public void clear() {
        this.list.clear();
    }
}
