import java.util.HashMap;
import java.util.Map;

/**
 * Create by weiyupeng on 2021/8/24 10:06
 */
public class S787 {
    private int res = -1;
    /**
     * 超时了！
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        boolean[] vis = new boolean[flights.length];
        backtrack(vis, flights, src, dst, k, 0, 0);
        return res;
    }

    private void backtrack(boolean[] vis, int[][] flights, int src, int dst, int k, int price, int step) {
        if (src == dst) {
            if (res == -1) {
                res = price;
            } else {
                res = Math.min(res, price);
            }
            return;
        }
        if (step > k) {
            return;
        }
        for (int i = 0; i < flights.length; i++) {
            if (vis[i] || src != flights[i][0]) {
                continue;
            }
            vis[i] = true;
            backtrack(vis, flights, flights[i][1], dst, k, price + flights[i][2], step + 1);
            vis[i] = false;
        }
    }
}
