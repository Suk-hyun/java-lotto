package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoBoard;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public static void countOfLotto(int count) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void allLotto(List<Lotto> allLotto) {
        for (Lotto lotto : allLotto) {
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }
    }

    public static void resultMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void allScore() {
        System.out.println("3개 일치 (5,000원) - " + LottoBoard.FIFTH.score() + "개");
        System.out.println("4개 일치 (50,000원) - " + LottoBoard.FOURTH.score() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + LottoBoard.THIRD.score() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + LottoBoard.SECOND.score() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + LottoBoard.FIRST.score() + "개");
    }

    public static void earningRate(int earningRate) {
        DecimalFormat decimalFormat = new DecimalFormat("##.0");
        System.out.println("총 수익률은 " + decimalFormat.format(earningRate) + "%입니다.");
    }
}
