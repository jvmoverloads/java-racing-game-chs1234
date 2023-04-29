package model;

import org.apache.commons.lang3.StringUtils;
import service.Movable;
import view.RacingGameView;

import java.util.List;

public class RacingCars {

    private final Cars cars;

    public RacingCars(String carNames) {
        this.cars = new Cars(carNames);
    }

    public void move(Movable moveStrategy) {
        cars.move(moveStrategy);
    }

    public void moveResult() {
        cars.moveResult();
    }

    public void printWinners() {
        RacingGameView.printText(findWinnerNames() + "가 최종 우승했습니다.");
    }

    private String findWinnerNames() {
        List<String> winners = cars.findWinnerNamesByPosition(cars.getWinnerPosition());
        return StringUtils.join(winners, ", ");
    }

}
