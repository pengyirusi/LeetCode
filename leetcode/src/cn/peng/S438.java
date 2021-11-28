package cn.peng;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Create by weiyupeng on 2021/11/28 14:36
 */
public class S438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int len = p.length();
        List<Integer> res = new LinkedList<>();
        if (s.length() < len) {
            return res;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            char ch = charArray[i];
            int num = map.getOrDefault(ch, 0) - 1;
            if (num == 0) {
                map.remove(ch);
            } else {
                map.put(ch, num);
            }
        }
        if (map.isEmpty()) {
            res.add(0);
        }
        for (int end = len; end < s.length(); end++) {
            int first = end - len;
            char poll = charArray[first];
            int num = map.getOrDefault(poll, 0) + 1;
            if (num == 0) {
                map.remove(poll);
            } else {
                map.put(poll, num);
            }
            char push = charArray[end];
            num = map.getOrDefault(push, 0) - 1;
            if (num == 0) {
                map.remove(push);
            } else {
                map.put(push, num);
            }
            if (map.isEmpty()) {
                res.add(first + 1);
            }
        }
        return res;
    }
}
