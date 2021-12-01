package cn.peng;

/**
 * Create by weiyupeng on 2021/12/1 20:59
 */
public class S1446 {
    public int maxPower(String s) {
        int res = 1;
        int max = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == c) {
                max++;
            } else {
                c = s.charAt(i);
                res = Math.max(res, max);
                max = 1;
            }
        }
        return Math.max(res, max);
    }
}
