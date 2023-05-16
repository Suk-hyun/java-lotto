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

    Score score = new Score();

    public void createLottoByPurchaseAmount() {
        OutputView.printPurchaseRequest();
        setPurchaseAmount();
        int numberOfLottoToCreate = purchaseAmount.getNumberOfLottoToCreate();
        service.createAllLottoByInput(numberOfLottoToCreate);
    }

    public void printNumberOfLotto() {
        OutputView.printNumberOfLotto(purchaseAmount.getNumberOfLottoToCreate());
    }

    public void printAllLotto() {
        OutputView.printAllLotto(service.getAllLotto());
    }

    public void setWinningNumbers() {
        OutputView.printWinningNumbersRequest();
        String input = InputView.getWinningNumbers();
        List<Integer> toIntList = Utils.inputToIntList(input);
        winningNumbers = new WinningNumbers(toIntList);
    }

    public void setBonusNumber() {
        OutputView.printBonusNumberRequest();
        String input = InputView.getBonusNumber();
        int toInt = Utils.stringToInt(input);
        bonusNumber = new BonusNumber(toInt, winningNumbers.getNumbers());
    }

    public void calculateScore() {
        service.calculateScore(winningNumbers.getNumbers(), bonusNumber.getNumber(), score);
    }

    public void printOutput() {
        OutputView.printScoreMessage();
        OutputView.printScore(score);
    }

    public void printEarningRate() {
        OutputView.printEarningRate(getEarningRate());
    }

    private void setPurchaseAmount() {
        String input = InputView.getPurchaseAmount();

        int inputToInt = Utils.stringToInt(input);

        purchaseAmount = new PurchaseAmount(inputToInt);
    }

    private double getEarningRate() {
        double totalPrize = service.getTotalPrize(score);
        double amount = purchaseAmount.getAmount();
        return totalPrize / amount;
    }
}