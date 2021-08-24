/**
 * Create by weiyupeng on 2021/8/2 20:06
 */
public class S743 {
    private int n;
    private int res = 0;
    public int networkDelayTime(int[][] times, int n, int k) {
        int edgeNum = times.length;
        this.n = n - 1;
        boolean[] usedEdge = new boolean[edgeNum];
        boolean[] usedPoint = new boolean[n + 1];
        return n == 0 ? dfs(times, usedEdge, usedPoint, k) : -1;
    }

    private int dfs(int[][] times, boolean[] usedEdge, boolean[] usedPoint, int k) {
        for (int i = 0; i < times.length; i++) {
            if (usedEdge[i] || times[i][0] != k) {
                continue;
            }
            usedEdge[i] = true;
            if (!usedPoint[times[i][1]]) {
                n--;
            }
            usedPoint[times[i][1]] = true;
            res = Math.max(res, times[i][2] + dfs(times, usedEdge, usedPoint, times[i][1]));
            usedEdge[i] = false;
        }
        return res;
    }
}
