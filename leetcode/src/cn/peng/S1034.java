package cn.peng;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create by weiyupeng on 2021/12/7 20:01
 */
public class S1034 {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int m;
    int n;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;
        Set<int[]> ans = new HashSet<>();
        boolean[][] vis = new boolean[m][n];
        dfs(ans, grid, row, col, vis);
        for (int[] ints : ans) {
            int x = ints[0], y = ints[1];
            grid[x][y] = color;
        }
        return grid;
    }

    private void dfs(Set<int[]> ans, int[][] grid, int row, int col, boolean[][] vis) {
        if (vis[row][col]) {
            return;
        }
        vis[row][col] = true;
        if (isBound(row, col)) {
            ans.add(new int[]{row, col});
        }
        for (int[] dir : dirs) {
            int x = dir[0] + row;
            int y = dir[1] + col;
            if (isIn(x, y) && grid[x][y] == grid[row][col]) {
                dfs(ans, grid, x, y, vis);
            }
        }
    }

    private boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private boolean isBound(int x, int y) {
        return x == 0 || y == 0 || x == m-1 || y == n-1;
    }

    /**
     * 1 2 1 2 1 2
     * 2 2 2 2 1 2
     * 1 2 2 2 1 2
     *
     * 1 1 1 1 1 2
     * 1 2 2 2 1 2
     * 1 1 1 1 1 2
     *
     * 1 1 1 1 1 2
     * 1 2 1 1 1 2
     * 1 1 1 1 1 2
     */

}
