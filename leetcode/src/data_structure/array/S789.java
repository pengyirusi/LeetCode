package data_structure.array;

/**
 * Create by weiyupeng on 2021/8/22 9:11
 */
public class S789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            if (Math.abs(ghost[0]-target[0]) + Math.abs(ghost[1]-target[1]) <= distance) {
                return false;
            }
        }
        return true;
    }
}
