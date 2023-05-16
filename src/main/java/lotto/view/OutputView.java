package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Score;
import lotto.domain.WinningPolicy;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class OutputView {

    public static void printPurchaseRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printWinningNumbersRequest() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberRequest() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printScoreMessage() {
        System.out.println("당첨 통계\n" +
                "---");
    }

    public static void printNumberOfLotto(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public static void printAllLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            List<Integer> list = lotto.getNumbers().stream()
                    .sorted().collect(Collectors.toList());
            System.out.println(list);
        }
    }

    public static void printScore(Score score) {
        Map<WinningPolicy, Integer> scoreMap = score.getScore();
        List<WinningPolicy> collect = Arrays.stream(WinningPolicy.values())
                .sorted(Comparator.comparingInt(WinningPolicy::getPrize))
        .collect(Collectors.toList());

        for (WinningPolicy value : collect) {

            int sameNumber = value.getSameNumber();

            int prize = value.getPrize();
            DecimalFormat df = new DecimalFormat("###,###");

            int scoreValue = scoreMap.get(value);

            if (value == WinningPolicy.SECOND) {
                System.out.println(sameNumber + "개 일치, 보너스 볼 일치 ("
                                + df.format(prize) + "원) - " + scoreValue + "개");
            }
            if (value != WinningPolicy.SECOND) {
                System.out.println(sameNumber + "개 일치 ("
                        + df.format(prize) + "원) - " + scoreValue + "개");
            }
        }
    }

    public static void printEarningRate(double earningRate) {
        DecimalFormat df = new DecimalFormat("#,###,###.0%");
        System.out.println("총 수익률은 " + df.format(earningRate) + "입니다.");
    }
}