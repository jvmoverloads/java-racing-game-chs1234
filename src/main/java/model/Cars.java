package model;

import util.InputValidator;
import view.RacingGameView;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        this.cars = makeCars(carNames);
    }

    public List<Car> makeCars(String carNames) {
        InputValidator.validCarNames(carNames);
        return Arrays.stream(carNames.split(",")).map(Car::new).toList();
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public void moveResult() {
        RacingGameView.printText("실행 결과");
        cars.forEach(Car::printCurrPosition);
        RacingGameView.printLine();
    }

    public void pickWinners() {
        int winnerPosition = cars.stream().mapToInt(Car::getCurrentPosition).max().getAsInt();
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> result.append(car.getNameIfWin(winnerPosition)));
        String winners = result.substring(0, result.length() - 2);
        RacingGameView.printText(winners + "가 최종 우승했습니다.");
    }
}
