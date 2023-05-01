package controller;

import exception.InvalidTryCountException;
import model.RacingCars;
import properties.ErrorMessage;
import service.Movable;
import service.RandomMoveConstraintsStrategy;
import view.RacingGameView;

public class RacingGameController {
    private RacingCars racingCars;
    private int tryCount;
    private Movable moveStrategy;

    public void start() {
        readyForRace();
        race();
        printWinners();
    }

    private void readyForRace() {
        initMoveStrategy();
        askCarNames();
        askTryCount();
    }

    private void initMoveStrategy() {
        this.moveStrategy = new RandomMoveConstraintsStrategy();
    }

    private void askCarNames() {
        RacingGameView.askCarNames();
        initRacingCars(RacingGameView.getConsoleInput());
    }

    private void askTryCount() {
        RacingGameView.askTryCount();
        initTryCount(RacingGameView.getConsoleInput());
    }

    private void initRacingCars(final String carNames) {
        this.racingCars = new RacingCars(carNames);
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
            racingCars.move(moveStrategy);
            racingCars.moveResult();
            playCount++;
        }
    }

    private void printWinners() {
        racingCars.printWinners();
    }
}
