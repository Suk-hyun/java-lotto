package lotto.utils;

public class Validator {
    private static final String EMPTY_INPUT = "[ERROR] 빈 문자입니다.";
    private static final String REQUEST_DIGIT = "[ERROR] 숫자를 입력해주세요.";

    public static void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
    }

    public static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(REQUEST_DIGIT);
        }
    }
}
