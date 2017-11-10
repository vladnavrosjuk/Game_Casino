package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 21.09.2017.
 */
public class RoulletAllScores {
    List<RoulletScore> scores;
    int randomnumber = 0 + (int) (Math.random() * 37);


    public RoulletAllScores() {
        scores = new ArrayList<>();
        scores.add(new RoulletScore(6.8, 15, 1));
        scores.add(new RoulletScore(7, 3, 0));
        scores.add(new RoulletScore(6.65, 34, 0));
        scores.add(new RoulletScore(6.5, 22, 1));
        scores.add(new RoulletScore(6.3, 5, 0));
        scores.add(new RoulletScore(6.15, 17, 1));
        scores.add(new RoulletScore(6.00, 32, 0));
        scores.add(new RoulletScore(5.8, 20, 1));
        scores.add(new RoulletScore(5.6, 7, 0));
        scores.add(new RoulletScore(5.5, 11, 1));
        scores.add(new RoulletScore(5.35, 30, 0));
        scores.add(new RoulletScore(5.20, 26, 1));
        scores.add(new RoulletScore(5.00, 9, 0));
        scores.add(new RoulletScore(4.8, 28, 1));
        scores.add(new RoulletScore(4.5, 2, 1));
        scores.add(new RoulletScore(4.3, 14, 0));
        scores.add(new RoulletScore(4.15, 35, 1));
        scores.add(new RoulletScore(4, 23, 0));
        scores.add(new RoulletScore(3.8, 4, 1));
        scores.add(new RoulletScore(3.65, 16, 0));
        scores.add(new RoulletScore(3.5, 33, 1));
        scores.add(new RoulletScore(3.3, 21, 0));
        scores.add(new RoulletScore(3.15, 6, 1));
        scores.add(new RoulletScore(3, 18, 0));
        scores.add(new RoulletScore(2.8, 31, 1));
        scores.add(new RoulletScore(2.6, 19, 0));
        scores.add(new RoulletScore(2.45, 8, 1));
        scores.add(new RoulletScore(2.3, 12, 0));
        scores.add(new RoulletScore(2.15, 29, 1));
        scores.add(new RoulletScore(2, 25, 0));
        scores.add(new RoulletScore(1.8, 10, 1));
        scores.add(new RoulletScore(1.65, 27, 0));
        scores.add(new RoulletScore(1.35, 1, 0));
        scores.add(new RoulletScore(1.15, 13, 1));
        scores.add(new RoulletScore(1, 35, 0));
        scores.add(new RoulletScore(0.8, 24, 1));

    }

    public Double getRandomScore() {
        return scores.get(randomnumber).angles;
    }

    public Integer getcor() {
        return scores.get(randomnumber).scores;
    }

    public Integer getcolor() {
        return scores.get(randomnumber).color;
    }
}
