package model;

public class Position {

    private int position;

    private static final int MOVE_CONDITION = 4;

    private static final String DISPLAY_CHARACTER = "-";

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void increasePosition() {
        position++;
    }

    public boolean canMove() {
        return createRandomNumber() >= MOVE_CONDITION;
    }

    public int createRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public String indicateCharacterByPosition() {
        return DISPLAY_CHARACTER.repeat(Math.max(0, position));
    }
}
