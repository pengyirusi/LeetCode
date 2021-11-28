package cn.peng;

/**
 * Create by weiyupeng on 2021/11/26 21:34
 */
public class S700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
