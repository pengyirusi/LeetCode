package cn.peng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by weiyupeng on 2021/9/4 23:02
 */
public class S5848 {

    int[] parent;
    Map<Integer, List<Integer>> map;
    boolean[] locked;
    int[] users;

    public S5848(int[] parent) {
        this.parent = parent;
        this.map = new HashMap<>();
        this.locked = new boolean[parent.length];
        this.users = new int[parent.length];
        for (int i = 0; i < parent.length; i++) {
            if (map.containsKey(parent[i])) {
                map.get(parent[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(parent[i], list);
            }
        }
    }

    public boolean lock(int num, int user) {
        if (!locked[num]) {
            locked[num] = true;
            users[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (locked[num] && users[num] == user) {
            locked[num] = false;
            users[num] = 0;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (locked[num]) {
            return false;
        }
        int cur = num;
        while (cur != -1) {
            if (locked[cur]) {
                return false;
            }
            cur = parent[cur];
        }

        List<Integer> children = new ArrayList<>();

        dfs(num, map, children);

        System.out.println(children);

        for (Integer child : children) {
            if (locked[child]) {
                for (Integer child1 : children) {
                    locked[child1] = false;
                    users[child1] = 0;
                }
                locked[num] = true;
                users[num] = user;
                return true;
            }
        }

        return false;
    }

    private void dfs(int num, Map<Integer, List<Integer>> map, List<Integer> children) {
        if (!map.containsKey(num)) {
            return;
        }
        for (Integer integer : map.get(num)) {
            children.add(integer);
            dfs(integer, map, children);
        }
    }
}
