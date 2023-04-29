package model;

import view.ResultView;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move() {
        if (!position.canMove())
            return;

        position.increasePosition();
    }

    public void printCurrPosition() {
        String display = "-".repeat(Math.max(0, position.getPosition()));
        ResultView.printText(name.getName() + ": " + display);
//        ResultView.printText(name.getName() + ": " + position.getPosition());
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
