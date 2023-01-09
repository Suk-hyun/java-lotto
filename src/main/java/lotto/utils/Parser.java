package lotto.utils;

public class Parser {

    public static String[] splitByComma(String input) {
        return input.split(",");
    }

    public static int stringToInt(String input) {
        Validator.isNumeric(input);
        return Integer.parseInt(input);
    }
}
