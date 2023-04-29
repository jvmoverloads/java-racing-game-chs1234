package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
    }

    public static void askTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static String getConsoleInput() {
        return scanner.nextLine();
    }
}
