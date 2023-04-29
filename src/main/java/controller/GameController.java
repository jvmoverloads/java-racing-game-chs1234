package controller;

import model.Cars;
import util.InputValidator;
import view.RacingGameView;

public class GameController {

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
        this.tryCount = InputValidator.getTryCount(tryCount);
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
