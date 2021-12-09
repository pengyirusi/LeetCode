package cn.peng;

import java.util.Arrays;

/**
 * Create by weiyupeng on 2021/12/9 20:56
 */
public class S794 {
    public boolean validTicTacToe(String[] board) {
        int o = 0, x = 0;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'O') {
                    o++;
                } else if (c == 'X') {
                    x++;
                }
            }
        }
        if (x - o > 1 || o > x || o + x == 9) {
            return false;
        }
        int[] row = new int[3];
        int[] col = new int[3];
        int[] xie = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'O') {
                    row[i]++;
                    col[j]++;
                    if (i == j) {
                        xie[0]++;
                    } else if (i + j == 2) {
                        xie[1]++;
                    }
                } else if (c == 'X') {
                    row[i]--;
                    col[j]--;
                    if (i == j) {
                        xie[0]--;
                    } else if (i + j == 2) {
                        xie[1]--;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(col));
        System.out.println(Arrays.toString(xie));
        boolean a = false, b = false;
        for (int i : row) {
            if (i == 3) {
                a = true;
            } else if (i == -3) {
                b = true;
            }
        }
        for (int i : col) {
            if (i == 3) {
                a = true;
            } else if (i == -3) {
                b = true;
            }
        }
        for (int i : xie) {
            if (i == 3) {
                a = true;
            } else if (i == -3) {
                b = true;
            }
        }
        int more = x - o;
        if (a && b) {
            return false;
        }
        if (!a && !b) {
            return true;
        }
        if (a && !b) {
            return more == 0;
        }
        return more == 1;
        /**
         * t t ? => f
         * t f 0 => f
         * t f 1 => t
         * f t 0 => t
         * f t 1 => f
         * f f ? => t
         */
    }
}
