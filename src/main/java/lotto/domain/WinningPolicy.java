package lotto.domain;

public enum WinningPolicy {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NOTHING(0, 0);

    private final int prize;
    private final int sameNumber;

    WinningPolicy(int prize, int sameNumber) {
        this.prize = prize;
        this.sameNumber = sameNumber;
    }

    public int getPrize() {
        return prize;
    }

    public int getSameNumber() {
        return sameNumber;
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
        return NOTHING;
    }
}