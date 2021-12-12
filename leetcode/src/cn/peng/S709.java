package cn.peng;

/**
 * Create by weiyupeng on 2021/12/12 18:44
 */
public class S709 {
    public String toLowerCase(String s) {
        int n;
        if (s == null || (n = s.length()) == 0) {
            return s;
        }
        char[] chs = new char[n];
        byte tran = 'a' - 'A';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                chs[i] = (char) (c + tran);
            } else {
                chs[i] = c;
            }
        }
        return new String(chs);
    }
}
