package lotto.domain;

public enum LottoPolicy {
    FIRST(1, 6, 2_000_000_000),
    SECOND(2, 5, 30_000_000),
    THIRD(3, 5, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(5, 3, 5_000);

    private final int rank;
    private final int countOfMatch;
    private final int winningMoney;

    LottoPolicy(int rank, int countOfMatch, int winningMoney) {
        this.rank = rank;
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getRank() {
        return rank;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
