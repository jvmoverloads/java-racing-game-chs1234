package model;

import exception.InvalidCarNameException;
import properties.ErrorMessage;
import view.RacingGameView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private static final String CAR_NAME_DELIMITER = ",";

    public Cars(String carNames) {
        this.cars = makeCars(carNames);
    }

    public List<Car> makeCars(String carNames) {
        validNames(carNames);
        return parsedCarNames(carNames).stream().map(Car::new).toList();
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

    private void validNames(String carNames) {
        if (carNames.isBlank())
            throw new InvalidCarNameException(ErrorMessage.CarName.NOT_ALLOW_EMPTY_OR_CONTAINS_WHITE_SPACE);

        if (!carNames.contains(CAR_NAME_DELIMITER))
            throw new InvalidCarNameException(ErrorMessage.CarName.NOT_EXIST_COMMA);

        if (carNames.startsWith(CAR_NAME_DELIMITER))
            throw new InvalidCarNameException(ErrorMessage.CarName.NOT_START_WITH_COMMA);

        if (carNames.endsWith(CAR_NAME_DELIMITER))
            throw new InvalidCarNameException(ErrorMessage.CarName.NOT_END_WITH_COMMA);

        List<String> carNamesList = parsedCarNames(carNames);
        HashSet<String> carNamesSet = new HashSet<>(carNamesList);
        if (carNamesList.size() != carNamesSet.size())
            throw new InvalidCarNameException(ErrorMessage.CarName.NOT_DUPLICATE_CAR_NAME);
    }

    private List<String> parsedCarNames(String carNames) {
        return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
    }
}
