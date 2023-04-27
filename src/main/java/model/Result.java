package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
public class Result implements Comparator<Result> {
    private String carName;
    private int position;

    @Override
    public int compare(Result result1, Result result2) {
        return result1.getPosition() - result2.getPosition();
    }
}
