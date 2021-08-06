package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Create by weiyupeng on 2021/8/6 18:20
 */
public class S847 {
    int res;
    public int shortestPathLength(int[][] graph) { // 超时了...
        int n = graph.length;
        int maxPath = (n - 1) << 1;
        res = maxPath;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            dfs(graph, i, set, maxPath, 0);
        }
        return res;
    }

    private void dfs(int[][] graph, int i, Set<Integer> set, int maxPath, int path) {
        if (set.isEmpty()) {
            res = Math.min(res, path);
            return;
        }
        if (path == maxPath) {
            return;
        }
        for (int j = 0; j < graph[i].length; j++) {
            if (set.contains(graph[i][j])) {
                set.remove(graph[i][j]);
                dfs(graph, graph[i][j], set, maxPath, path + 1);
                set.add(graph[i][j]);
            } else {
                dfs(graph, graph[i][j], set, maxPath, path + 1);
            }
        }
    }
}
