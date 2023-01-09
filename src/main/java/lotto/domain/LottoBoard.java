package lotto.domain;

public enum LottoBoard {
    FIRST(1, 0, 2_000_000_000),
    SECOND(2, 0, 30_000_000),
    THIRD(3, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(5, 0, 5_000);

    private final int rank;
    private final int winningMoney;
    private int score;

    LottoBoard(int rank, int score, int winningMoney) {
        this.rank = rank;
        this.score = score;
        this.winningMoney = winningMoney;
    }

    public int rank() {
        return rank;
    }

    public int score() {
        return score;
    }

    public void incScore() {
        score++;
    }

    public int winningMoney() {
        return winningMoney;
    }
}
