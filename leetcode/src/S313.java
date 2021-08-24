import java.util.Arrays;

/**
 * Create by weiyupeng on 2021/8/9 18:53
 */
public class S313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        Arrays.sort(primes);
        int len = primes.length;
        int[] index = new int[len];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                min = Math.min(min, arr[index[j]] * primes[j]);
            }
            for (int j = 0; j < len; j++) {
                if (min == arr[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
            arr[i] = min;
        }
        return arr[n - 1];
    }
}
