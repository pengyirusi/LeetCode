import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Create by weiyupeng on 2021/10/8 20:00
 */
public class S187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> ret = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String substring = s.substring(i, i + 10);
            if (set.contains(substring)) {
                ret.add(substring);
            }
            set.add(substring);
        }
        List<String> list = new LinkedList<>();
        for (String str : ret) {
            list.add(str);
        }
        return list;
    }
}
