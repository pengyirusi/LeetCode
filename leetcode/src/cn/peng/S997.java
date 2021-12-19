package cn.peng;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create by weiyupeng on 2021/12/19 16:07
 */
public class S997 {
    public int findJudge(int n, int[][] trust) {
        Set<Integer> notJudge = new HashSet<>(n*2);
        int[] votes = new int[n + 1];
        for (int[] ints : trust) {
            notJudge.add(ints[0]);
            votes[ints[1]]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (votes[i] == n - 1 && !notJudge.contains(i)) {
                res.add(i);
            }
        }
        return res.size() == 1 ? res.get(0) : -1;
    }
}
