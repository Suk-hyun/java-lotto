package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Score;
import lotto.domain.WinningPolicy;

import java.util.List;

public class LottoService {

    private final LottoRepository lottoRepository = new LottoRepository();

    public List<Lotto> getAllLotto() {
        return lottoRepository.getLottoList();
    }

    public void createAllLottoByInput(int input) {

        for (int i = 0; i < input; i++) {
            createLotto();
        }
    }

    public void calculateScore(List<Integer> winningNumbers, int bonusNumber, Score score) {
        List<Lotto> lottoList = getAllLotto();

        for (Lotto lotto : lottoList) {
            WinningPolicy result = getResult(winningNumbers, bonusNumber, lotto);
            score.incScore(result);
        }
    }

    public int getTotalPrize(Score score) {
        int totalPrize = 0;
        for (WinningPolicy value : WinningPolicy.values()) {
            int prize = value.getPrize();
            int count = score.getScore().get(value);
            totalPrize += prize * count;
        }
        return totalPrize;
    }

    private WinningPolicy getResult(List<Integer> winningNumbers, int bonusNumber, Lotto lotto) {
        int sameNumber = lotto.countSameNumber(winningNumbers);
        return WinningPolicy.getResult(sameNumber, bonusNumber, lotto);
    }

    private void createLotto() {
        Lotto lotto = Lotto.createLotto(createRandomNumbers());
        lottoRepository.save(lotto);
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}