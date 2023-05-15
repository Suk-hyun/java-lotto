package lotto.domain;

public enum WinningPolicy {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000);

    private final int prize;

    WinningPolicy(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static WinningPolicy getResult(int sameNumber , int bonusNumber, Lotto lotto) {
        if (sameNumber == 6) {
            return FIRST;
        }
        if (sameNumber == 5 && lotto.hasNumber(bonusNumber)) {
            return SECOND;
        }
        if (sameNumber == 5 && !lotto.hasNumber(bonusNumber)) {
            return THIRD;
        }
        if (sameNumber == 4) {
            return FOURTH;
        }
        if (sameNumber == 3) {
            return FIFTH;
        }
        return null;
    }
}