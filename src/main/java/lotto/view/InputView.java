package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static void requestPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static String readPurchaseMoney() {
        return Console.readLine();
    }

    public static void requestWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static String readWinningNumber() {
        return Console.readLine();
    }

    public static void requestBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public static String readBonusNumber() {
        return Console.readLine();
    }
}
