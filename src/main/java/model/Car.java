package model;

import lombok.Getter;

@Getter
public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");

        this.name = name;
    }

    public void move() {
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber < 4)
            return;

        this.position++;
    }
}
