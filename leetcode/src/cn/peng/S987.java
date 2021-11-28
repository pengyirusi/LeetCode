package cn.peng;

import java.util.*;

/**
 * Create by weiyupeng on 2021/7/31 11:39
 */
public class S987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> list = new ArrayList<>();

        dfs(root, 0, 0, list);

        list.sort(Comparator.comparingInt(a -> a[2]));
        list.sort(Comparator.comparingInt(a -> a[0]));
        list.sort(Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i < list.size(); ) {
            int col = list.get(i)[1];
            List<Integer> arrayList = new ArrayList<>();
            while (i < list.size() && list.get(i)[1] == col) {
                arrayList.add(list.get(i)[2]);
                i++;
            }
            res.add(arrayList);
        }

        return res;
    }

    private void dfs(TreeNode root, int i, int j, List<int[]> list) {
        list.add(new int[]{i, j, root.val});

        if (root.left != null) {
            dfs(root.left, i + 1, j - 1, list);
        }
        if (root.right != null) {
            dfs(root.right, i + 1, j + 1, list);
        }
    }
}
