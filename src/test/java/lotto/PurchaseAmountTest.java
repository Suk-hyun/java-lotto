package lotto;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {

    @DisplayName("구매 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByInvalidValue() {
        assertThatThrownBy(() -> new PurchaseAmount(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}