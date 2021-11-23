import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Create by weiyupeng on 2021/10/22 19:32
 */
public class S3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chs = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (char c : chs) {
            queue.add(c);
            if (set.contains(c)) {
                while (!queue.isEmpty() && queue.peek() != c) {
                    set.remove(queue.poll());
                }
            }
            set.add(c);
            max = Math.max(max, set.size());
        }
        return max;
    }
}
