package model;

import view.RacingGameView;

public class Car {

    private final CarName name;
    private final Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public void move() {
        if (!position.canMove())
            return;

        position.increasePosition();
    }

    public void printCurrPosition() {
        RacingGameView.printText(
                name.getName() + " : " + position.indicateCharacterByPosition()
        );
    }

    public int getCurrentPosition() {
        return position.getPosition();
    }

    public String getNameIfWin(int winnerPosition) {
        if (position.getPosition() == winnerPosition)
            return name.getName() + ", ";

        return "";
    }
}
