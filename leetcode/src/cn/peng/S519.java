package cn.peng;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

/**
 * Create by weiyupeng on 2021/11/27 15:23
 */
public class S519 {

    Map<Integer, Integer> map = new HashMap<>();
    int m, n, total;
    Random rand = new Random();

    public S519(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
    }

    public int[] flip() {
        int x = rand.nextInt(total);
        total--;
        // 查找位置 x 对应的映射
        int idx = map.getOrDefault(x, x);
        // 将位置 x 对应的映射设置为位置 total 对应的映射
        map.put(x, map.getOrDefault(total, total));
        return new int[]{idx / n, idx % n};
    }

    public void reset() {
        total = m * n;
        map.clear();
    }
}
