package cn.peng;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by weiyupeng on 2021/8/25 20:12
 */
public class S797 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int num = graph.length;
        boolean[] vis = new boolean[num];
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, num - 1, vis, path);
        return res;
    }

    private void dfs(int[][] graph, int start, int end, boolean[] vis, List<Integer> path) {
        if (start == end) {
            res.add(new ArrayList<>(path));
            return;
        }
        vis[start] = true;
        for (int next : graph[start]) {
            if (vis[next]) {
                continue;
            }
            path.add(next);
            dfs(graph, next, end, vis, path);
            path.remove(path.size() - 1);
        }
        vis[start] = false;
    }
}
