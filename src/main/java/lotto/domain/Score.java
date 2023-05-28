package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private static final int INITIAL_SCORE = 0;
    Map<WinningPolicy, Integer> score;

    public Score() {
        init();
    }

    public void incScore(WinningPolicy eachRank) {
        if (eachRank != WinningPolicy.NOTHING) {
            score.replace(eachRank, score.get(eachRank) + 1);
        }
    }

    public Map<WinningPolicy, Integer> getScore() {
        return score;
    }

    private void init() {
        score = new HashMap<>();
        for (WinningPolicy eachRank : WinningPolicy.values()) {
            score.put(eachRank, INITIAL_SCORE);
        }
    }
}