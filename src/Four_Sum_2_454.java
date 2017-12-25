import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongjianlv on 17-12-25.
 */
public class Four_Sum_2_454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int num = 0;
        int sum;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                sum = C[i] + D[j];
                num += map.getOrDefault(-1 * sum, 0);
            }
        }

        return num;
    }
}
