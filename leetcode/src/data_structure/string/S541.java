package data_structure.string;

/**
 * Create by weiyupeng on 2021/8/20 8:15
 */
public class S541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int step = k * 2;
        for (int i = 0; i < chars.length; i += step) {
            mySwap(chars, i, k);
        }
        return String.valueOf(chars);
    }

    private void mySwap(char[] chars, int i, int k) {
        int j = Math.min(chars.length - 1, i + k - 1);
        while (i < j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++;
            j--;
        }
    }
}
