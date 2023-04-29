package util;

import org.apache.commons.lang3.StringUtils;
import properties.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputValidator {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int CAR_NAME_LENGTH = 5;

    public static void validCarNames(String carNames) {
        isEmptyOrContainWhiteSpace(carNames);
        isNotStartsWithComma(carNames);
        isNotEndsWithComma(carNames);
        canSplitByComma(carNames);
        isNotExceedFiveCharacters(carNames);
        isNotDuplicateCarName(carNames);
    }

    public static int getTryCount(String tryCount) {
        isEmptyOrContainWhiteSpace(tryCount);
        isNotIncludeZeroCount(tryCount);
        return isInteger(tryCount);
    }

    private static int isInteger(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.TryCount.NOT_INTEGER);
        }
    }

    private static void isEmptyOrContainWhiteSpace(String carNames) {
        if (StringUtils.isBlank(carNames))
            throw new IllegalArgumentException(ErrorMessage.CarName.NOT_ALLOW_EMPTY_OR_CONTAINS_WHITE_SPACE);
    }

    private static void isNotStartsWithComma(String carNames) {
        if (carNames.startsWith(CAR_NAME_DELIMITER))
            throw new IllegalArgumentException(ErrorMessage.CarName.NOT_START_WITH_COMMA);
    }

    private static void isNotEndsWithComma(String carNames) {
        if (carNames.endsWith(CAR_NAME_DELIMITER))
            throw new IllegalArgumentException(ErrorMessage.CarName.NOT_END_WITH_COMMA);
    }

    private static void canSplitByComma(String carNames) {
        if (!carNames.contains(CAR_NAME_DELIMITER))
            throw new IllegalArgumentException(ErrorMessage.CarName.NOT_EXIST_COMMA);
    }

    private static void isNotExceedFiveCharacters(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
        if (carNameList.stream().anyMatch(carName -> carName.length() > CAR_NAME_LENGTH))
            throw new IllegalArgumentException(ErrorMessage.CarName.NOT_EXCEED_CAR_NAME_LENGTH);
    }

    private static void isNotDuplicateCarName(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
        HashSet<String> carNameSet = new HashSet<>(carNameList);
        if (carNameList.size() != carNameSet.size())
            throw new IllegalArgumentException(ErrorMessage.CarName.NOT_DUPLICATE_CAR_NAME);
    }

    private static void isNotIncludeZeroCount(String tryCount) {
        if (tryCount.equals("0"))
            throw new IllegalArgumentException(ErrorMessage.TryCount.NOT_INCLUDE_ZERO_COUNT);
    }
}
