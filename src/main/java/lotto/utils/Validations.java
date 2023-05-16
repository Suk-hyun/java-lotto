package lotto.utils;

import java.util.List;

public class Validations {

    public static void validate(List<Integer> numbers) {
        isValidRangeForList(numbers);
        isValidSize(numbers);
        isDuplicate(numbers);
    }

    private static void isDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            System.out.println("[ERROR] 중복되지 않은 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    private static void isValidSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 6개의 숫자를 입력해주세요.");
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
            System.out.println("[ERROR] 1에서 45 사이의 숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}