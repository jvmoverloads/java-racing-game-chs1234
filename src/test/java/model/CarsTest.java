package model;


import exception.InvalidCarNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import properties.ErrorMessage;
import service.Movable;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @ParameterizedTest
    @MethodSource("invalidParameters")
    @DisplayName("잘못된 자동차 이름 에러 테스트")
    void test(String parameter, String name) {
        InvalidCarNameException invalidCarNameException = assertThrows(InvalidCarNameException.class, () -> new Cars(parameter));
        assertEquals(name, invalidCarNameException.getMessage());
    }

    @Test
    @DisplayName("가장 멀리간 자동차의 position은 winnerPosition이다")
    void test2() {
        Cars cars = new Cars("ko,ho,seung");
        cars.move(() -> true);
        assertEquals(cars.getWinnerPosition(), 1);
    }

    @Test
    @DisplayName("우승자의 position으로 우승자들의 이름을 가져온다.")
    void test3() {
        Movable movable = () -> true;

        var porsche = new Car("포르쉐");
        porsche.move(movable);

        var zhivagen = new Car("지바겐");
        zhivagen.move(movable);
        zhivagen.move(movable);

        var lamborghini = new Car("람보르기니");
        lamborghini.move(movable);
        lamborghini.move(movable);

        var cars = new Cars(List.of(porsche, zhivagen, lamborghini));
        assertTrue(cars.findWinnerNamesByPosition(2).toString().contains("ho, seung"));
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
                Arguments.of("", ErrorMessage.CarName.NOT_ALLOW_EMPTY_OR_CONTAINS_WHITE_SPACE),
                Arguments.of(" ", ErrorMessage.CarName.NOT_ALLOW_EMPTY_OR_CONTAINS_WHITE_SPACE),
                Arguments.of("onlyOneCar", ErrorMessage.CarName.NOT_EXIST_COMMA),
                Arguments.of("12345,123456", ErrorMessage.CarName.NOT_EXCEED_CAR_NAME_LENGTH),
                Arguments.of(",car", ErrorMessage.CarName.NOT_START_WITH_COMMA),
                Arguments.of("car,", ErrorMessage.CarName.NOT_END_WITH_COMMA),
                Arguments.of("car1,car1,car2", ErrorMessage.CarName.NOT_DUPLICATE_CAR_NAME)
        );
    }

}