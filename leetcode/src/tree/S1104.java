package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by weiyupeng on 2021/7/29 18:14
 * 1104.path-in-zigzag-labelled-binary-tree
 */
public class S1104 {
    public List<Integer> pathInZigZagTree(int label) {
        int len = getMax(label);
        int[] tree = new int[len];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = i + 1;
        }
//        1-1,2-3,4-7,8-15,
        boolean rev = false;
        for (int i = 0, range = 1; i < len; range *= 2) {
            if (rev) {
                reverse(tree, i, i + range - 1);
            }
            i += range;
            rev = !rev;
        }
        // 0    1 2     3 4 5 6      7 8 9 10 11 12 13 14
        List<Integer> res = new ArrayList<>();

        int index = tree.length - 1;
        while (tree[index] != label) {
            index--;
        }

        while (index >= 0) {
            res.add(0, tree[index]);
            if (index == 0) {
                break;
            }
            index = (index - 1) / 2;
        }

        return res;
    }

    private void reverse(int[] tree, int i, int j) {
        while (i < j) {
            int t = tree[i];
            tree[i] = tree[j];
            tree[j] = t;
            i++;
            j--;
        }
    }

    private int getMax(int label) {
        int a = 1;
        while (a <= label) {
            a *= 2;
        }
        return a - 1;
    }

    public static void main(String[] args) {
        S1104 s1104 = new S1104();
        System.out.println(s1104.getMax(1));
        System.out.println(s1104.getMax(2));
        System.out.println(s1104.getMax(3));
        System.out.println(s1104.getMax(4));
        System.out.println(s1104.getMax(7));
        System.out.println(s1104.getMax(8));
        System.out.println(s1104.getMax(15));

        System.out.println(-1 / 2);
    }
}
