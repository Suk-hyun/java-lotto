package lotto;

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
    public int compare(List<Integer> winningNumber) {
        int result = 0;
        for (Integer number : winningNumber) {
            if (numbers.contains(number)) {
                result++;
            }
        }
        return result;
    }

    public Boolean hasNumber(int i) {
        return numbers.contains(i);
    }
}
