package model;

import exception.InvalidPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("위치 값은 음수일 수 없다.")
    void test() {
        Assertions.assertThrows(InvalidPositionException.class, () -> new Position(-1));
    }

    @Test
    @DisplayName("move를 하면 position을 증가시킨다.")
    void test2() {
        Assertions.assertEquals(new Position(1), new Position().increasePosition());
    }

}