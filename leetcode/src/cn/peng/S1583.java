package cn.peng;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by weiyupeng on 2021/8/14 17:17
 */
public class S1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int[] pair : pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }
        int res = 0;
        for (int[] pair : pairs) {
            for (int person : pair) {
                A: for (int i = 0; preferences[person][i] != map.get(person); i++) {
                    int better = preferences[person][i];
                    int pairOfBetter = map.get(better);
                    for (int j = 0; preferences[better][j] != pairOfBetter; j++) {
                        if (preferences[better][j] == person) {
                            res++;
                            break A;
                        }
                    }
                }
            }
        }
        return res;
    }
}
