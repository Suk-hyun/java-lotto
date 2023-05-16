package lotto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private final List<Lotto> lottoList = new ArrayList<>();

    public void save(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
