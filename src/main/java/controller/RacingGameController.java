package controller;

import exception.InvalidTryCountException;
import model.Cars;
import properties.ErrorMessage;
import view.RacingGameView;

public class RacingGameController {

    private Cars cars;
    private int tryCount;

    public void start() {
        init();
        race();
        result();
    }

    private void init() {
        RacingGameView.askCarNames();
        initCars(RacingGameView.getConsoleInput());
        RacingGameView.askTryCount();
        initTryCount(RacingGameView.getConsoleInput());
    }

    private void initCars(final String carNames) {
        cars = new Cars(carNames);
    }

    private void initTryCount(final String tryCount) {
        this.tryCount = parsedTryCount(tryCount);
    }

    private int parsedTryCount(String tryCount) {
        try {
            int parsedTryCount = Integer.parseInt(tryCount);
            if (parsedTryCount <= 0)
                throw new InvalidTryCountException(ErrorMessage.TryCount.NOT_POSITIVE_NUMBER);

            return parsedTryCount;
        } catch (IllegalArgumentException e) {
            throw new InvalidTryCountException(ErrorMessage.TryCount.NOT_POSITIVE_NUMBER);
        }
    }

    private void race() {
        int playCount = 0;
        while (playCount != tryCount) {
            cars.move();
            cars.moveResult();
            playCount++;
        }
    }

    private void result() {
        cars.pickWinners();
    }
}
