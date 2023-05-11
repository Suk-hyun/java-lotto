package lotto;

public class PurchaseAmount {

    public static final int LOTTO_PRICE = 1000;
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        isDividableWithLottoPrice(amount);
    }

    private void isDividableWithLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getNumberOfLottoToCreate() {
        return amount / LOTTO_PRICE;
    }
}