package lotto;

import java.util.List;

public class Controller {

    LottoService service = new LottoService();
    PurchaseAmount amount;
    WinningNumbers winningNumbers;

    public void createLottoByPurchaseAmount() {
        setPurchaseAmount();
        int numberOfLottoToCreate = amount.getNumberOfLottoToCreate();
        service.createAllLottoByInput(numberOfLottoToCreate);
    }

    public void setWinningNumbers() {
        String input = InputView.getWinningNumbers();
        List<Integer> toIntList = Utils.inputToIntList(input);
        winningNumbers = new WinningNumbers(toIntList);
    }

    private void setPurchaseAmount() {
        String input = InputView.getPurchaseAmount();

        int inputToInt = Utils.stringToInt(input);

        amount = new PurchaseAmount(inputToInt);
    }
}