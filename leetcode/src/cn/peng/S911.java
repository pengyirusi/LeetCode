package cn.peng;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by weiyupeng on 2021/12/11 11:20
 */
public class S911 {
    Map<Integer, Integer> personsVote;
    int[] winners;
    int max = 0;
    int winner = -1;
    int[] times;
    int n;
    Map<Integer, Integer> log = new HashMap<>();
    public S911(int[] persons, int[] times) {
        this.times = times;
        n = persons.length;
        personsVote = new HashMap<>(2*n);
        winners = new int[n];
        for (int i = 0; i < n; i++) {
            int num = personsVote.getOrDefault(persons[i], 0) + 1;
            personsVote.put(persons[i], num);
            if (num >= max) {
                winner = persons[i];
                max = num;
            }
            winners[i] = winner;
        }
        System.out.println(Arrays.toString(winners));
    }

    public int q(int t) {
        if (log.containsKey(t)) {
            return log.get(t);
        }
        for (int i = 0; i < n; i++) {
            if (t < times[i]) {
                log.put(t, winners[i - 1]);
                return winners[i - 1];
            } else if (t == times[i]) {
                log.put(t, winners[i]);
                return winners[i];
            }
        }
        log.put(t, winner);
        return winner;
    }
}
