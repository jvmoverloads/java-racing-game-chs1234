package util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputValidator {

    public static void validCarNames(String carNames) {
        isEmptyOrContainWhiteSpace(carNames);
        isNotStartsWithComma(carNames);
        isNotEndsWithComma(carNames);
        canSplitByComma(carNames);
        isExistMoreThanTwoCars(carNames);
        isNotDuplicateCarName(carNames);
    }

    public static int getTryCount(String tryCount) {
        try {
            isEmptyOrContainWhiteSpace(tryCount);
            isNotIncludeZeroCount(tryCount);
            return Integer.parseInt(tryCount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수 입력값은 정수여야만 합니다.");
        }
    }

    private static void isEmptyOrContainWhiteSpace(String carNames) {
        if (StringUtils.isBlank(carNames))
            throw new IllegalArgumentException("[ERROR] 공백 혹은 빈 값이 포함되어있습니다.");
    }

    private static void isNotStartsWithComma(String carNames) {
        if (carNames.startsWith(","))
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 ,로 시작할 수 없습니다.");
    }

    private static void isNotEndsWithComma(String carNames) {
        if (carNames.endsWith(","))
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 ,로 끝날 수 없습니다.");
    }

    private static void canSplitByComma(String carNames) {
        if (!carNames.contains(","))
            throw new IllegalArgumentException("[ERROR] 자동차 들을 구분할 때는 ,를 사용해야 합니다.");
    }

    private static void isNotDuplicateCarName(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(","));
        HashSet<String> carNameSet = new HashSet<>(carNameList);
        if (carNameList.size() != carNameSet.size())
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 서로 중복될 수 없습니다.");
    }

    private static void isExistMoreThanTwoCars(String carNames) {
        if (carNames.split(",").length < 2)
            throw new IllegalArgumentException("[ERROR] 자동차는 최소 2대 이상이어야 합니다.");
    }

    private static void isNotIncludeZeroCount(String tryCount) {
        if (tryCount.equals("0"))
            throw new IllegalArgumentException("[ERROR] 시도 횟수 입력값은 0을 포함할 수 없습니다.");
    }
}
