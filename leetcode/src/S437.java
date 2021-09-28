/**
 * Create by weiyupeng on 2021/9/28 19:51
 */
public class S437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == targetSum) {
            res++;
        }
        if (root.left != null) {
            res += pathSum(root.left, targetSum) + pathSum(root.right, targetSum - root.val);
        }
        if (root.right != null) {
            res += pathSum(root.right, targetSum) + pathSum(root.right, targetSum - root.val);
        }
        return res;
    }
}
