package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import properties.ErrorMessage;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름은 빈 값 혹은 공백을 포함하지 않는다. - 자동차 이름")
    void not_allow_empty_or_contains_white_space() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            String carNames = "";
            InputValidator.validCarNames(carNames);
        });

        Assertions.assertEquals(ErrorMessage.CarName.NOT_ALLOW_EMPTY_OR_CONTAINS_WHITE_SPACE, illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("자동차 이름은 ,로 시작할 수 없다.")
    void not_start_with_comma() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            String carNames = ",car";
            InputValidator.validCarNames(carNames);
        });

        Assertions.assertEquals(ErrorMessage.CarName.NOT_START_WITH_COMMA, illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("자동차 이름은 ,로 끝날 수 없다.")
    void not_end_with_comma() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            String carNames = "car1,car2,";
            InputValidator.validCarNames(carNames);
        });

        Assertions.assertEquals(ErrorMessage.CarName.NOT_END_WITH_COMMA, illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("자동차는 최소 2대 이상이어야 한다.")
    void not_exist_comma() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            String carNames = "car";
            InputValidator.validCarNames(carNames);
        });

        Assertions.assertEquals(ErrorMessage.CarName.NOT_EXIST_COMMA, illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void not_exceed_car_name_length() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            String carNames = "car1,car123";
            InputValidator.validCarNames(carNames);
        });

        Assertions.assertEquals(ErrorMessage.CarName.NOT_EXCEED_CAR_NAME_LENGTH, illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("자동차 이름은 서로 중복될 수 없다.")
    void not_duplicate_car_name() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            String carNames = "car,car";
            InputValidator.validCarNames(carNames);
        });

        Assertions.assertEquals(ErrorMessage.CarName.NOT_DUPLICATE_CAR_NAME, illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("공백 혹은 빈 값이 포함되어 있습니다. - 시도 횟수")
    void not_allow_empty_or_contains_white_space_try_count() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            String tryCount = "";
            InputValidator.getTryCount(tryCount);
        });

        Assertions.assertEquals(ErrorMessage.TryCount.NOT_ALLOW_EMPTY_OR_CONTAINS_WHITE_SPACE, illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("시도 횟수 입력값은 0을 포함할 수 없다.")
    void not_include_zero_count() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            String tryCount = "0";
            InputValidator.getTryCount(tryCount);
        });

        Assertions.assertEquals(ErrorMessage.TryCount.NOT_INCLUDE_ZERO_COUNT, illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("시도 횟수 입력값은 정수여야 한다.")
    void not_integer() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            String tryCount = "dkfj";
            InputValidator.getTryCount(tryCount);
        });

        Assertions.assertEquals(ErrorMessage.TryCount.NOT_INTEGER, illegalArgumentException.getMessage());
    }
}