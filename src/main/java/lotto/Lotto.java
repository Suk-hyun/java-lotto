package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidSize(numbers);
        isDuplicate(numbers);
    }

    private void isDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void isValidSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

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
