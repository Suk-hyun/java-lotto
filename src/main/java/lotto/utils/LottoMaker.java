package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.service.LottoService;

import java.util.List;

public class LottoMaker {

    private static final int LOTTO_PRICE = 1000;
    public static void makeAllLotto(LottoService service, int countOfLottoToMake) {
        for (int i = 0; i < countOfLottoToMake; i++) { // 로또 만들고 저장
            List<Integer> randomLottoNumbers = makeRandomLottoNumbers();
            service.saveLotto(new Lotto(randomLottoNumbers));
        }
    }

    public static int calculateCountOfLottoToMake(int money) {
        return money / LOTTO_PRICE;
    }

    public static List<Integer> makeRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
