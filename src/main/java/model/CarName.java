package model;

import exception.InvalidCarNameException;
import lombok.Getter;
import properties.ErrorMessage;

@Getter
public class CarName {
    private final String name;

    private static final int CAR_NAME_MAX_LENGTH = 5;

    public CarName(final String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH)
            throw new InvalidCarNameException(ErrorMessage.CarName.NOT_EXCEED_CAR_NAME_LENGTH);

        this.name = name;
    }
}
