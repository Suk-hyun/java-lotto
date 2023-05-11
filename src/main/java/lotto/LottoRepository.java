package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private final List<Lotto> lottoList = new ArrayList<>();

    public void save(Lotto lotto) {
        lottoList.add(lotto);
    }
}
