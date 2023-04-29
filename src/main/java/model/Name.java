package model;

import lombok.Getter;

@Getter
public class Name {
    private final String name;

    public Name(final String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");

        this.name = name;
    }
}
