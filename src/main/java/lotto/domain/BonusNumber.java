package lotto.domain;

import lotto.utils.Validations;

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
            System.out.println("ERROR] 당첨번호와 중복되지 않는 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}