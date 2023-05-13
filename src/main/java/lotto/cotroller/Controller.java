package lotto.cotroller;

import lotto.domain.BonusNumber;
import lotto.view.InputView;
import lotto.LottoService;
import lotto.Utils;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

import java.util.List;

public class Controller {

    LottoService service = new LottoService();
    PurchaseAmount amount;
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;

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

    public void setBonusNumber() {
        String input = InputView.getBonusNumber();
        int toInt = Utils.stringToInt(input);
        bonusNumber = new BonusNumber(toInt);
    }

    private void setPurchaseAmount() {
        String input = InputView.getPurchaseAmount();

        int inputToInt = Utils.stringToInt(input);

        amount = new PurchaseAmount(inputToInt);
    }
}