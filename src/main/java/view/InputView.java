package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        // validation 추가
        return scanner.nextLine();
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        // validation
        return scanner.nextInt();
    }

    public void validate(String carNames) {
        /**
         * 입력값 검증
         * 1. 빈 값 혹은 공백만 있는 경우
         * 2. ","로 시작하는 경우
         * 3. 자동차 이름 중복
         * 4. 자동차 한 대 이름의 길이가 5글자가 넘는 경우
         * 5. 자동차 이름이 한 개일 경우
         * 6. 횟수 입력값이 숫자가 아닐 경우
         * 7. 횟수 입력값이 빈 값 혹은 0일 경우
         */
    }
}
