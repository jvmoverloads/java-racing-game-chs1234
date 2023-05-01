package model;

import exception.InvalidCarNameException;
import properties.ErrorMessage;
import service.Movable;
import view.RacingGameView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    private static final String CAR_NAME_DELIMITER = ",";

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String carNames) {
        this.cars = makeCars(carNames);
    }

    public List<Car> makeCars(String carNames) {
        validNames(carNames);
        return parsedCarNames(carNames).stream().map(Car::new).toList();
    }

    public void move(Movable moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public void moveResult() {
        RacingGameView.printText("실행 결과");
        cars.forEach(Car::printCurrPosition);
        RacingGameView.printLine();
    }

    public int getWinnerPosition() {
        return cars.stream().mapToInt(Car::getCurrentPosition).max().getAsInt();
    }

    public List<String> findWinnerNamesByPosition(int winnerPosition) {
        StringBuilder result = new StringBuilder();
        cars.forEach(car ->
                result.append(car.getNameIfWin(winnerPosition)).append(",")
        );

        return Stream.of(result.toString().split(","))
                .filter(winner -> !winner.isBlank())
                .collect(Collectors.toList());
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
