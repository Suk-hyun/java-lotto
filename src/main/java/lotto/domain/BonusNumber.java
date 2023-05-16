package lotto.domain;

import lotto.Validations;

import java.util.List;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number, List<Integer> winningNumbers) {
        Validations.isValidRange(number);
        isDuplicateWithWinningNumber(number, winningNumbers);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void isDuplicateWithWinningNumber(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}