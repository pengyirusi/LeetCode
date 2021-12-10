package cn.peng;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Create by weiyupeng on 2021/12/10 19:59
 */
public class S748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        return Arrays.stream(words)
                .filter(word -> canFill(licensePlate, word))
                .sorted(Comparator.comparingInt(String::length))
                .limit(1)
                .collect(Collectors.toList())
                .get(0);
    }

    private boolean canFill(String licensePlate, String word) {
        int sum = 0;
        int[] chs = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                chs[c - 'a']++;
                sum++;
            } else if (c >= 'A' && c <= 'Z') {
                chs[c - 'A']++;
                sum++;
            }
        }
        for (char c : word.toCharArray()) {
            if (chs[c - 'a'] > 0) {
                chs[c - 'a']--;
                sum--;
            }
            if (sum == 0) {
                return true;
            }
        }
        return false;
    }
}
