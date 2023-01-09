package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingNumber(List<Integer> winningNumbers) {
        int result = 0;
        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                result++;
            }
        }
        return result;
    }
}
