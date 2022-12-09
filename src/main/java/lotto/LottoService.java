package lotto;

import lotto.domain.LottoPolicy;

import java.util.List;

public class LottoService {

    public int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int result = 0;
        for (Integer winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                result++;
            }
        }
        return result;
    }

    public int classifyRank(int result, List<Integer> lottoNumbers, int bonusNum) {
        if (result == 3) {
            return LottoPolicy.FIFTH.rank();
        }
        if (result == 4) {
            return LottoPolicy.FOURTH.rank();
        }
        if (result == 5) {
            if (lottoNumbers.contains(bonusNum)) {
                return LottoPolicy.SECOND.rank();
            }
            return LottoPolicy.THIRD.rank();
        }
        return LottoPolicy.FIRST.rank();
    }
}
