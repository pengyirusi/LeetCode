package data_structure.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by weiyupeng on 2021/8/12 8:14
 */
public class S516 {
    Map<String, Integer> map = new HashMap<>();
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int n = s.length();
        int res;
        if (s.charAt(0) == s.charAt(n - 1)) {
            res = 2 + longestPalindromeSubseq(s.substring(1, n - 1));
        } else {
            res = Math.max(longestPalindromeSubseq(s.substring(1, n)), longestPalindromeSubseq(s.substring(0, n - 1)));
        }
        map.put(s, res);
        return res;
    }
}
