package model;

import service.Movable;
import view.RacingGameView;

public class Car {

    private final CarName name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public void move(Movable moveStrategy) {
        if (!moveStrategy.canMove())
            return;

        this.position = this.position.increasePosition();
    }

    public void printCurrPosition() {
        RacingGameView.printText(
                name.getName() + " : " + position.getPosition()
        );
    }

    public int getCurrentPosition() {
        return position.getPosition().length();
    }

    public String getNameIfWin(int winnerPosition) {
        if (position.getPosition().length() == winnerPosition)
            return name.getName();

        return "";
    }
}
