package properties;

public class ErrorMessage {

    public static class CarName {
        public static final String NOT_ALLOW_EMPTY_OR_CONTAINS_WHITE_SPACE = "[ERROR] 공백 혹은 빈 값이 포함되어 있습니다.";
        public static final String NOT_START_WITH_COMMA = "[ERROR] 자동차 이름은 ,로 시작할 수 없습니다.";
        public static final String NOT_END_WITH_COMMA = "[ERROR] 자동차 이름은 ,로 끝날 수 없습니다.";
        public static final String NOT_EXIST_COMMA = "[ERROR] 자동차는 최소 2대 이상이어야 합니다.";
        public static final String NOT_EXCEED_CAR_NAME_LENGTH = "[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.";
        public static final String NOT_DUPLICATE_CAR_NAME = "[ERROR] 자동차 이름은 서로 중복될 수 없습니다.";
    }

    public static class TryCount {
        public static final String NOT_ALLOW_EMPTY_OR_CONTAINS_WHITE_SPACE = "[ERROR] 공백 혹은 빈 값이 포함되어 있습니다.";
        public static final String NOT_INCLUDE_ZERO_COUNT = "[ERROR] 시도 횟수 입력값은 0을 포함할 수 없습니다.";
        public static final String NOT_INTEGER = "[ERROR] 시도 횟수 입력값은 정수여야만 합니다.";
    }
}
