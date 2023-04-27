package controller;

import model.Car;
import model.Game;
import model.Results;
import view.InputView;
import view.ResultView;

public class GameController {

    private final Car car;

    private final Game game;

    private final InputView inputView;
    private final ResultView resultView;

    public GameController() {
        this.car = new Car("TEST");
        this.game = new Game();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void start() {
        String carNames = inputView.getCarNames();
        int tryCount = inputView.getTryCount();

        Results results = new Results();
        for (int i = 0; i < tryCount; i++) {
            results = game.race();
            resultView.printResult(results);
        }
        resultView.printWinners(results);
    }
}
