import java.util.HashMap;
import java.util.Map;

/**
 * Create by weiyupeng on 2021/8/15 9:01
 */
public class S576 {

    /**
     * dfs 超时：76 / 94 个通过测试用例
     */
    /*int res = 0;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dfs(m, n, maxMove, startRow, startColumn);
        return res;
    }

    private void dfs(int m, int n, int maxMove, int startRow, int startColumn) {
        if (startRow < 0 || startRow == m || startColumn < 0 || startColumn == n) {
            res++;
            return;
        }
        if (maxMove == 0) {
            return;
        }
        for (int[] dir : dirs) {
            int nextRow = startRow + dir[0];
            int nextColumn = startColumn + dir[1];
            dfs(m, n, maxMove - 1, nextRow, nextColumn);
        }
    }*/

    /**
     * 有记录的 dfs
     */
    /*Map<String, Integer> map = new HashMap<>();
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // map 保存的是从 [i,j] 走到 [x,y] 后剩余步数为 N 再走到边界的路径数
        return dfs(m, n, maxMove, startRow, startColumn);
    }

    public int dfs(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove < 0) {
            return 0;
        }
        if (maxMove < startRow + 1 && maxMove < startColumn + 1 && maxMove < m - startRow && maxMove < n - startColumn) {
            return 0;
        }
        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
            return 1;
        }
        if (map.containsKey(startRow + "," + startColumn + "," + maxMove)) {
            return map.get(startRow + "," + startColumn + "," + maxMove);
        }
        int count = 0;
        count = (count + dfs(m, n, maxMove - 1, startRow + 1, startColumn)) % 1000000007;
        count = (count + dfs(m, n, maxMove - 1, startRow - 1, startColumn)) % 1000000007;
        count = (count + dfs(m, n, maxMove - 1, startRow, startColumn + 1)) % 1000000007;
        count = (count + dfs(m, n, maxMove - 1, startRow, startColumn - 1)) % 1000000007;
        map.put(startRow + "," + startColumn + "," + maxMove, count);
        return count;
    }*/

    /**
     * dp O(4*n^3)
     */
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int k = 0; k < maxMove; k++) {
            int[][] tmp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        if (i + dir[0] < 0 || i + dir[0] >= m || j + dir[1] < 0 || j + dir[1] >= n) {
                            // 出界了，该位置 +1
                            tmp[i][j]++;
                        } else {
                            // 没出界，该位置 + 上一轮旁边格子的数
                            tmp[i][j] = (tmp[i][j] + dp[i+dir[0]][j + dir[1]]) % 1000000007;
                        }
                    }
                }
            }
            dp = tmp;
        }
        return dp[startRow][startColumn];
    }
}
