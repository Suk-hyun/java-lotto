package lotto.domain;

public enum WinningPolicy {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH;

    public static WinningPolicy getResult(int sameNumber ,int bonusNumber, Lotto lotto) {
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