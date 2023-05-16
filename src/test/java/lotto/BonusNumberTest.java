package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("당첨번호와 중복된 번호를 입력하면 예외를 발생시킨다.")
    @Test
    void isDuplicateWithWinningNumbers() {
        assertThatThrownBy(() -> new BonusNumber(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BonusNumber(6, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1과 45사이의 정수가 아니면 예외를 발생시킨다.")
    @Test
    void inValidNumberTest() {
        assertThatThrownBy(() -> new BonusNumber(46, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BonusNumber(0, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}