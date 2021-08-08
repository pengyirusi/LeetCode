package algorithm.tree;

import algorithm.common.TreeNode;

import java.util.Arrays;

/**
 * Create by weiyupeng on 2021/7/27 22:42
 * 671.second-minimum-node-in-a-binary-java.tree
 */
public class S671 {
    public int findSecondMinimumValue(TreeNode root) {
        long[] res = new long[2];
        Arrays.fill(res, Long.MAX_VALUE);
        dfs(res, root);
        return res[1] == Long.MAX_VALUE ? -1 : (int)res[1];
    }

    private void dfs(long[] res, TreeNode root) {
        int val = root.val;
        if (val < res[0]) {
            res[1] = res[0];
            res[0] = val;
        } else if (val > res[0] && val < res[1]) {
            res[1] = val;
        }
        if (root.left != null) {
            dfs(res, root.left);
        }
        if (root.right != null) {
            dfs(res, root.right);
        }
    }
}
