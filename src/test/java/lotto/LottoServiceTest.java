package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoServiceTest {

    LottoService service = new LottoService();

    @Test
    void test() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int result = service.countMatchingNumbers(lottoNumbers, winningNumbers);
        Assertions.assertThat(result).isEqualTo(6);


    }

    @Test
    void test2() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 7, 8);
        int result = service.countMatchingNumbers(lottoNumbers, winningNumbers);
        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    void test3() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;
        int rank = service.classifyRank(5, lottoNumbers, bonusNum);

        Assertions.assertThat(rank).isEqualTo(3);
    }

    @Test
    void test4() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 6;
        int rank = service.classifyRank(5, lottoNumbers, bonusNum);

        Assertions.assertThat(rank).isEqualTo(2);
    }

}