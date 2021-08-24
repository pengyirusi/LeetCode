/**
 * Create by weiyupeng on 2021/8/17 8:30
 */
public class S551 {
    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int a = 0, l = 0;
        for (char c : chars) {
            if (c == 'L') {
                l++;
            } else {
                l = 0;
                if (c == 'A') {
                    a++;
                }
            }
            if (a > 1 || l > 2) {
                return false;
            }
        }
        return true;
    }
}
