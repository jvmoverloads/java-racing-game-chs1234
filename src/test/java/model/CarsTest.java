package model;


import exception.InvalidCarNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import properties.ErrorMessage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {

    @ParameterizedTest
    @MethodSource("invalidParameters")
    @DisplayName("잘못된 자동차 이름 에러 테스트")
    void test(String parameter, String name) {
        InvalidCarNameException invalidCarNameException = assertThrows(InvalidCarNameException.class, () -> new Cars(parameter));
        assertEquals(name, invalidCarNameException.getMessage());
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