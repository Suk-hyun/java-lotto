package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStorage {
    private final List<Lotto> lottoStorage = new ArrayList<>();

    public void save(Lotto lotto) {
        lottoStorage.add(lotto);
    }

    public List<Lotto> getAll() {
        return lottoStorage;
    }

    /**
     * 핵심로직임.
     */
    public void computeScore(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottoStorage) {
            compute(lotto.countMatchingNumber(winningNumbers), lotto.getNumbers(), bonusNumber);
        }
    }

    private void compute(int countOfMatchingNumbers, List<Integer> lottoNumbers, int bonusNumber) {
        fifthRank(countOfMatchingNumbers);
        fourthRank(countOfMatchingNumbers);
        thirdRank(countOfMatchingNumbers, lottoNumbers, bonusNumber);
        secondRank(countOfMatchingNumbers, lottoNumbers, bonusNumber);
        firstRank(countOfMatchingNumbers);
    }

    private void firstRank(int result) {
        if (result == 6) {
            LottoBoard.FIRST.incScore();
        }
    }

    private void thirdRank(int result, List<Integer> lottoNumbers, int bonusNumber) {
        if (result == 5 && !lottoNumbers.contains(bonusNumber)) {
            LottoBoard.THIRD.incScore();
        }
    }

    private void secondRank(int result, List<Integer> lottoNumbers, int bonusNumber) {
        if (result == 5 && lottoNumbers.contains(bonusNumber)) {
            LottoBoard.SECOND.incScore();
        }
    }

    private void fourthRank(int result) {
        if (result == 4) {
            LottoBoard.FOURTH.incScore();
        }
    }

    private void fifthRank(int result) {
        if (result == 3) {
            LottoBoard.FIFTH.incScore();
        }
    }
}
