package cn.peng;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by weiyupeng on 2021/12/2 20:30
 */
public class S506 {
    public String[] findRelativeRanks(int[] score) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "Gold Medal");
        map.put("2", "Silver Medal");
        map.put("3", "Bronze Medal");
        int len = score.length;
        int[][] scoreAndPos = new int[len][2];
        for (int i = 0; i < len; i++) {
            scoreAndPos[i][0] = score[i];
            scoreAndPos[i][1] = i;
        }
        Arrays.sort(scoreAndPos, (a, b) -> b[0] - a[0]);
        String[] ans = new String[len];
        for (int i = 0; i < len; i++) {
            int j = scoreAndPos[i][1];
            String s = String.valueOf(i + 1);
            ans[j] = map.getOrDefault(s, s);
        }
        return ans;
    }
}
