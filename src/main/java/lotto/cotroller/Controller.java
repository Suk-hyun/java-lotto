package lotto.cotroller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.LottoService;
import lotto.utils.Utils;
import lotto.view.OutputView;

import java.util.List;

public class Controller {

    LottoService service = new LottoService();
    PurchaseAmount purchaseAmount;
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;
    Score score;

    public void start() {
        try {
            createLottoByPurchaseAmount();
            printNumberOfLotto();
            printAllLotto();
            setWinningNumbers();
            setBonusNumber();
            calculateScore();
            printScore();
            printEarningRate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createLottoByPurchaseAmount() {
        OutputView.printPurchaseRequest();
        String input = InputView.getPurchaseAmount();

        setPurchaseAmount(input);
        int numberOfLottoToCreate = purchaseAmount.getNumberOfLottoToCreate();
        service.createAllLottoByInput(numberOfLottoToCreate);
    }

    private void printNumberOfLotto() {
        OutputView.printNumberOfLotto(purchaseAmount.getNumberOfLottoToCreate());
    }

    private void printAllLotto() {
        OutputView.printAllLotto(service.getAllLotto());
    }

    private void setWinningNumbers() {
        OutputView.printWinningNumbersRequest();
        String input = InputView.getWinningNumbers();
        List<Integer> toIntList = Utils.inputToIntList(input);
        winningNumbers = new WinningNumbers(toIntList);
    }

    private void setBonusNumber() {
        OutputView.printBonusNumberRequest();
        String input = InputView.getBonusNumber();
        int toInt = Utils.stringToInt(input);
        bonusNumber = new BonusNumber(toInt, winningNumbers.getNumbers());
    }

    private void calculateScore() {
        score = new Score();
        service.calculateScore(winningNumbers.getNumbers(), bonusNumber.getNumber(), score);
    }

    private void printScore() {
        OutputView.printScoreMessage();
        OutputView.printScore(score);
    }

    private void printEarningRate() {
        OutputView.printEarningRate(getEarningRate());
    }

    private void setPurchaseAmount(String input) {
        int inputToInt = Utils.stringToInt(input);
        purchaseAmount = new PurchaseAmount(inputToInt);
    }

    private double getEarningRate() {
        double totalPrize = service.getTotalPrize(score);
        double amount = purchaseAmount.getAmount();
        return totalPrize / amount;
    }
}