package lotto.domain;

import lotto.utils.Validations;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        Validations.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}