/**
 * Create by weiyupeng on 2021/7/30 22:18
 */
public class S171 {
    public int titleToNumber(String columnTitle) {
        char[] chs = columnTitle.toCharArray();
        int res = 0;
        for (int i = chs.length - 1, mul = 1; i >= 0; i--, mul *= 26) {
            res += mul * (chs[i] - 'A' + 1);
        }
        return res;
    }
}
