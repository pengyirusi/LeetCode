import java.util.*;

/**
 * Create by weiyupeng on 2021/7/28 20:53
 * 863.all-nodes-distance-k-in-binary-java.tree
 */
public class S863 {
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();

        // 从 root 出发，记录所有节点的父节点
        dfs(root);

        // 从 target 出发，往各个方向遍历
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> used = new HashSet<>();
        queue.add(target);
        used.add(target);
        while (k-- > 0 && !queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();

                if (node.left != null && !used.contains(node.left)) {
                    queue.add(node.left);
                    used.add(node.left);
                }
                if (node.right != null && !used.contains(node.right)) {
                    queue.add(node.right);
                    used.add(node.right);
                }
                if (map.containsKey(node) && !used.contains(map.get(node))) {
                    TreeNode treeNode = map.get(node);
                    queue.add(treeNode);
                    used.add(treeNode);
                }
            }
        }
        for (TreeNode treeNode : queue) {
            res.add(treeNode.val);
        }

        return res;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            map.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            dfs(root.right);
        }
    }
}
