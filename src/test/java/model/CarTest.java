package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    @DisplayName("move전략의 움직임 여부가 true면 위치값이 1 증가한다.")
    void test() {
        Car car = new Car("seung");
        car.move(() -> true);

        assertEquals(1, car.getCurrentPosition());
    }

    @Test
    @DisplayName("move전략의 움직임 여부가 false면 움직이지 않는다.")
    void test2() {
        Car car = new Car("seung");
        car.move(() -> false);

        assertEquals(0, car.getCurrentPosition());
    }
}
