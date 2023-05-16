package lotto;

import java.util.List;

public class Validations {

    public static void validate(List<Integer> numbers) {
        isValidRangeForList(numbers);
        isValidSize(numbers);
        isDuplicate(numbers);
    }

    private static void isDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isValidSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidRangeForList(List<Integer> numbers) {
        for (Integer number : numbers) {
            isValidRange(number);
        }
    }

    public static void isValidRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }
}