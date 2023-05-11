package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoService {

    private final LottoRepository lottoRepository = new LottoRepository();

    public void createAllLottoByInput(int input) {

        for (int i = 0; i < input; i++) {
            Lotto lotto = Lotto.createLotto(createRandomNumbers());
            lottoRepository.save(lotto);
        }
    }
    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}