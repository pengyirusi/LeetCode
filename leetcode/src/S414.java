import java.util.LinkedList;
import java.util.List;

/**
 * Create by weiyupeng on 2021/10/6 19:35
 */
public class S414 {
    public int thirdMax(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            if (list.isEmpty()) {
                list.add(num);
                break;
            }
            boolean add = false;
            for (int i = 0; i < list.size() && i < 3; i++) {
                if (num > list.get(i)) {
                    list.add(i, num);
                    add = true;
                    break;
                }
                if (num == list.get(i)) {
                    add = true;
                    break;
                }
            }
            if (!add && list.size() < 3) {
                list.add(num);
            }
        }
        return list.get(Math.min(list.size() - 1, 2));
    }
}
