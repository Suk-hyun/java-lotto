package lotto;

public class Controller {

    LottoService service = new LottoService();
    PurchaseAmount amount;

    public void createLottoByPurchaseAmount() {
        setPurchaseAmount();
        int numberOfLottoToCreate = amount.getNumberOfLottoToCreate();
        service.createAllLottoByInput(numberOfLottoToCreate);
    }

    private void setPurchaseAmount() {
        String input = InputView.getPurchaseAmount();

        int inputToInt = Utils.stringToInt(input);

        amount = new PurchaseAmount(inputToInt);
    }
}