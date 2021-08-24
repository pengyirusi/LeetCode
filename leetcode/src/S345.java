import java.util.HashSet;
import java.util.Set;

/**
 * Create by weiyupeng on 2021/8/19 8:53
 */
public class S345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        Set<Character> set = new HashSet<>(10);
        for (char c : "AaEeIiOoUu".toCharArray()) {
            set.add(c);
        }
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (i < j && !set.contains(chars[i])) {
                i++;
            }
            while (i < j && !set.contains(chars[j])) {
                j--;
            }
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
}
