import java.util.ArrayList;
import java.util.List;

/**
 * Create by weiyupeng on 2021/9/14 17:31
 */
public class S524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String word : dictionary) {
            if (can(s, word)) {
                res = swap(res, word);
            }
        }
        return res;
    }

    private String swap(String res, String word) {
        if (word.length() > res.length()) {
            return word;
        } else if (word.length() < res.length()) {
            return res;
        }
        List<String> list = new ArrayList<>();
        return compare(res, word) ? res : word;
    }

    private boolean compare(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return true;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean can(String s, String word) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word.length();
    }
}
