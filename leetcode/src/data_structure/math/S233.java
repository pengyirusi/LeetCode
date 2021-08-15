package data_structure.math;

/**
 * Create by weiyupeng on 2021/8/13 8:32
 */
public class S233 {
    /**
     * 递归 不知道 为啥 不行 ！
     * @param n
     * @return
     */
    /*public int countDigitOne(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        if (len == 1) {
            return n != 0 ? 1 : 0;
        }
        int res = 0;
        int first = s.charAt(0) - '0'; // first >= 1
        int end = Integer.parseInt(s.substring(1));
        if (first == 1) {
            res += end + 1;
        } else {
            res += pow10(len - 1);
        }

        res += (first + 1) * countDigitOne(end);
        return res;
    }

    private int pow10(int i) {
        if (i == 0) {
            return 1;
        }
        return 10 * pow10(i - 1);
    }*/

    public int countDigitOne(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        S233 s233 = new S233();
        System.out.println(s233.countDigitOne(256));
        System.out.println(s233.countDigitOne(13));
    }
}
