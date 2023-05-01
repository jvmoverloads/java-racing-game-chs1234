package model;

import exception.InvalidPositionException;
import properties.ErrorMessage;

import java.util.Objects;

public class Position {

    private final int position;

    private static final String DISPLAY_CHARACTER = "-";

    public Position() {
        this(0);
    }

    public Position(int position) {
        if (position < 0)
            throw new InvalidPositionException(ErrorMessage.Position.NOT_POSITIVE_NUMBER);

        this.position = position;
    }

    public Position increasePosition() {
        return new Position(position + 1);
    }

    public String getPosition() {
        return DISPLAY_CHARACTER.repeat(Math.max(0, position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
