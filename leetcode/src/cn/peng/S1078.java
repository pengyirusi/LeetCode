package cn.peng;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weiyupeng
 * @create 2021/12/26 10:32
 */
public class S1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> list = new ArrayList<>();
        int length = words.length;
        for (int i = 0; i < length - 2; i++) {
            if (words[i].equals(first)) {
                if (words[i + 1].equals(second)) {
                    list.add(words[i + 2]);
                }
            }
        }
        int size = list.size();
        String[] res = new String[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
