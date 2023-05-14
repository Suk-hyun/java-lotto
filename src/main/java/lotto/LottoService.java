package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Score;
import lotto.domain.WinningPolicy;

import java.util.List;

public class LottoService {

    private final LottoRepository lottoRepository = new LottoRepository();

    Score score = new Score();

    public void getResult(List<Integer> winningNumbers, int bonusNumber) {
        List<Lotto> lottoList = getAllLotto();

        for (Lotto lotto : lottoList) {
            int sameNumber = lotto.countSameNumber(winningNumbers);
            WinningPolicy result = WinningPolicy.getResult(sameNumber, bonusNumber, lotto);
            score.incScore(result);
        }
    }

    public List<Lotto> getAllLotto() {
        return lottoRepository.getLottoList();
    }

    public void createAllLottoByInput(int input) {

        for (int i = 0; i < input; i++) {
            createLotto();
        }
    }

    private void createLotto() {
        Lotto lotto = Lotto.createLotto(createRandomNumbers());
        lottoRepository.save(lotto);
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}