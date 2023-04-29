package model;

import lombok.Getter;

@Getter
public class Name {
    private final String name;

    public Name(final String name) {
        this.name = name;
    }
}
