package lotto;

import java.util.List;

public class LottoService {

    public int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int result = 0;
        for (Integer winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                result ++;
            }
        }
        return result;
    }
}
