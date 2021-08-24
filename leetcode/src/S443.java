/**
 * Create by weiyupeng on 2021/8/21 8:51
 */
public class S443 {
    public int compress(char[] chars) {
        char curCh = chars[0];
        int num = 1;
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == curCh) {
                num++;
            } else {
                chars[j++] = curCh;
                if (num != 1) {
                    for (char c : String.valueOf(num).toCharArray()) {
                        chars[j++] = c;
                    }
                }
                curCh = chars[i];
                num = 1;
            }
        }
        chars[j++] = curCh;
        if (num != 1) {
            for (char c : String.valueOf(num).toCharArray()) {
                chars[j++] = c;
            }
        }
        return j;
    }
}
