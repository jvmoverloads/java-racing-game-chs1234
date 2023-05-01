package model;

import exception.InvalidCarNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import properties.ErrorMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    @DisplayName("잘못된 자동차 이름 에러 테스트")
    void test(String parameter) {
        InvalidCarNameException invalidCarNameException = assertThrows(InvalidCarNameException.class, () -> new CarName(parameter));
        assertEquals(ErrorMessage.CarName.NOT_EXCEED_CAR_NAME_LENGTH, invalidCarNameException.getMessage());
    }
}