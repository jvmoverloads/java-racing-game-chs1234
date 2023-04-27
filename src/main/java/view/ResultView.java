package view;

import model.Result;
import model.Results;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ResultView {

    public void printWinners(Results results) {
        List<String> filtered = results.getResults().stream()
                .filter(result -> result.getPosition() == 5)
                .map(Result::getCarName)
                .toList();

        String winners = StringUtils.join(filtered, ",");
        System.out.println("최종 우승자 = " + winners);
    }

    public void printResult(Results results) {
        results.getResults().forEach(result -> System.out.println(result.getCarName() + ": " + result.getPosition()));
    }
}
