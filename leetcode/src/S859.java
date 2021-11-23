import java.util.HashSet;
import java.util.Set;

/**
 * Create by weiyupeng on 2021/11/23 17:54
 */
public class S859 {
    public boolean buddyStrings(String s, String goal) {
        int len = s.length();
        if (len == 1 || len != goal.length()) {
            return false;
        }
        char[] arr = new char[4];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char cs = s.charAt(i);
            char cg = goal.charAt(i);
            if (cs == cg) {
                continue;
            }
            if (index == 4) {
                return false;
            }
            arr[index++] = cs;
            arr[index++] = cg;
        }
        if (index == 2) {
            return false;
        }
        if (index == 4) {
            return arr[0] == arr[3] && arr[1] == arr[2];
        }

        // index == 0
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }
}
