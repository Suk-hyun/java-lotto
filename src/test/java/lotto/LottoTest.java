package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("당첨번호와 로또번호 사이에 같은 수의 개수를 구하는 기능")
    @Test
    void countSameNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.compare(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(6);

        assertThat(lotto.compare(List.of(1, 2, 3, 4, 5, 10))).isEqualTo(5);

        assertThat(lotto.compare(List.of(1, 2, 3, 4, 10, 11))).isEqualTo(4);

        assertThat(lotto.compare(List.of(1, 2, 3, 10, 11, 12))).isEqualTo(3);

        assertThat(lotto.compare(List.of(1, 2, 10, 11, 12, 13))).isEqualTo(2);

        assertThat(lotto.compare(List.of(1, 10, 11, 12, 13, 14))).isEqualTo(1);

        assertThat(lotto.compare(List.of(10, 11, 12, 13, 14, 15))).isEqualTo(0);
    }

    @DisplayName("보너스 번호가 로또번호에 있는지 판단하는 기능")
    @Test
    void hasBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.hasNumber(1)).isTrue();
        assertThat(lotto.hasNumber(7)).isFalse();
    }

    @DisplayName("중복된 숫자 값이 있으면 예외를 발생시킨다")
    @Test
    void isDuplicate() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6자리가 아니면 예외를 발생시킨다")
    @Test
    void isValidSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
