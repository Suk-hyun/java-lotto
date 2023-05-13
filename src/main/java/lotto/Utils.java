package lotto;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static final String COMMA = ",";

    public static int stringToInt(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해 주세요");
            return stringToInt(InputView.getPurchaseAmount());
        }
    }

    public static List<Integer> inputToIntList(String input) {
        List<Integer> result = new ArrayList<>();

        String[] split = splitByComma(input);

        for (String s : split) {
            int parseInt = stringToInt(s);
            result.add(parseInt);
        }
        return result;
    }

    private static String[] splitByComma(String input) {
        return input.split(COMMA);
    }
}