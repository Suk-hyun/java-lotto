package lotto.domain;

import lotto.utils.Validations;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validations.validate(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int countSameNumber(List<Integer> winningNumber) {
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

    public List<Integer> getNumbers() {
        return numbers;
    }
}
