package cn.peng;

/**
 * Create by weiyupeng on 2021/12/6 19:52
 */
public class S1816 {
    public String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int min = Math.min(s1.length, k);
        for (int i = 0; i < min; i++) {
            sb.append(' ').append(s1[i]);
        }
        return sb.substring(1);
    }
}
