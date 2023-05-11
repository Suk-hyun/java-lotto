package lotto;

public class Utils {

    public static int stringToInt(String string) {

        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해 주세요");
            return stringToInt(InputView.getPurchaseAmount());
        }
    }
}