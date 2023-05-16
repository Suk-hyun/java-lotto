package lotto;

import lotto.cotroller.Controller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();

        controller.createLottoByPurchaseAmount();
        controller.printNumberOfLotto();
        controller.printAllLotto();
        controller.setWinningNumbers();
        controller.setBonusNumber();
        controller.calculateScore();
        controller.printOutput();
        controller.printEarningRate();
    }
}
