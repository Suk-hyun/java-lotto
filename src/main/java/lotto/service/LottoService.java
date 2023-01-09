package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoBoard;
import lotto.domain.LottoStorage;

import java.util.List;

public class LottoService {
    LottoStorage lottoStorage = new LottoStorage();

    public void saveLotto(Lotto lotto) {
        lottoStorage.save(lotto);
    }

    public List<Lotto> getAllLotto() {
        return lottoStorage.getAll();
    }

    public void computeScore(List<Integer> winningNumbers, int bonusNumber) {
        lottoStorage.computeScore(winningNumbers, bonusNumber);
    }

    public int computeEarningRate(int purchaseMoney) {
        int netWinningMoney = computeNetWinningMoney();
        return netWinningMoney / purchaseMoney;
    }

    private int computeNetWinningMoney() {
        return LottoBoard.FIFTH.score() * LottoBoard.FIFTH.winningMoney() +
                LottoBoard.FOURTH.score() * LottoBoard.FOURTH.winningMoney() +
                LottoBoard.THIRD.score() * LottoBoard.THIRD.winningMoney() +
                LottoBoard.SECOND.score() * LottoBoard.SECOND.winningMoney() +
                LottoBoard.FIRST.score() * LottoBoard.FIRST.winningMoney();
    }
}
