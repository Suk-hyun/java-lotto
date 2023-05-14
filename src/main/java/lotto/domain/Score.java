package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Score {

    public static final int INITIAL_SCORE = 0;
    Map<WinningPolicy, Integer> score;

    public Score() {
        init();
    }

    public void incScore(WinningPolicy key) {
        if (score.get(key) != null) {
            score.replace(key, score.get(key) + 1);
        }
    }

    public Map<WinningPolicy, Integer> getScore() {
        return score;
    }

    private void init() {
        score = new HashMap<>();
        score.put(WinningPolicy.FIRST, INITIAL_SCORE);
        score.put(WinningPolicy.SECOND, INITIAL_SCORE);
        score.put(WinningPolicy.THIRD, INITIAL_SCORE);
        score.put(WinningPolicy.FOURTH, INITIAL_SCORE);
        score.put(WinningPolicy.FIFTH, INITIAL_SCORE);
    }
}