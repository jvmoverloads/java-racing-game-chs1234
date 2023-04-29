package model;

import util.InputValidator;
import view.ResultView;

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

    // inputview, resultview -> gameview 한번 더 추상화, 응집도 높이기.
    public void moveResult() {
        ResultView.printText("실행 결과");
        cars.forEach(Car::printCurrPosition);
        ResultView.printLine();
    }

    public void pickWinners() {
        int winnerPosition = cars.stream().mapToInt(Car::getCurrentPosition).max().getAsInt();
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> result.append(car.getNameIfWin(winnerPosition)));
        String winners = result.substring(0, result.length() - 2);
        ResultView.printText(winners + "가 최종 우승했습니다.");
    }
}
