package cn.peng;

/**
 * Create by weiyupeng on 2021/11/30 20:29
 */
public class S400 {
    public int findNthDigit(int n) {
        // 9 * 1
        // 90 * 2
        // 900 * 3
        // 9000 * 4

        long a = 9;
        int b = 1;
        long nl = n;
        while (nl > 0) {
            nl -= a * b;
            a *= 10;
            b++;
        }
        a /= 10;
        b--;
        nl += a * b;
        n = (int)nl;
        int start = (int)a / 9;
        int c = n/b, d = n%b;
        int end = start + c;
        if (d == 0) {
            String s = String.valueOf(end - 1);
            return s.charAt(s.length()-1) - '0';
        } else {
            String s = String.valueOf(end);
            return s.charAt(d-1) - '0';
        }
    }
}
