package model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public Results race() {
        Results results = new Results();
        results.setResults(dummyResultList());

        return results;
    }

    private List<Result> dummyResultList() {
        List<Result> resultList = new ArrayList<>();

        Result result1 = new Result();
        result1.setCarName("pobi");
        result1.setPosition(3);

        Result result2 = new Result();
        result2.setCarName("seung");
        result2.setPosition(5);

        Result result3 = new Result();
        result3.setCarName("minsu");
        result3.setPosition(2);

        resultList.add(result1);
        resultList.add(result2);
        resultList.add(result3);

        return resultList;
    }
}
