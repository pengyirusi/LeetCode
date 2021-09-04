import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by weiyupeng on 2021/9/4 22:40
 */
public class S5847 {
    public int[][] findFarmland(int[][] land) {
        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    continue;
                }
                int i2 = i;
                for ( ; i2 < land.length; i2++) {
                    if (land[i2][j] == 0) {
                        break;
                    }
                }
                i2--;
                int j2 = j;
                for ( ; j2 < land[0].length; j2++) {
                    if (land[i][j2] == 0) {
                        break;
                    }
                }
                j2--;
                int[] ints = new int[4];
                ints[0] = i;
                ints[1] = j;
                ints[2] = i2;
                ints[3] = j2;
                lists.add(ints);
                for (int i3 = i; i3 <= i2; i3++) {
                    for (int j3 = j; j3 <= j2; j3++) {
                        land[i3][j3] = 0;
                    }
                }
            }
        }
        int size = lists.size();
        int[][] res = new int[size][];
        for (int i = 0; i < size; i++) {
            res[i] = lists.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        S5847 s5847 = new S5847();
        int[][] arr = {{1,0,0},{0,1,1},{0,1,1}};
        int[][] farmland = s5847.findFarmland(arr);
        System.out.println(Arrays.deepToString(farmland));
    }
}
