import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by zhongjianlv on 18-3-25.
 * <p>
 * Given an array nums of integers, you can perform operations on the array.
 * <p>
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 * <p>
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 * <p>
 * Example 1:
 * Input: nums = [3, 4, 2]
 * Output: 6
 * Explanation:
 * Delete 4 to earn 4 points, consequently 3 is also deleted.
 * Then, delete 2 to earn 2 points. 6 total points are earned.
 * Example 2:
 * Input: nums = [2, 2, 3, 3, 3, 4]
 * Output: 9
 * Explanation:
 * Delete 3 to earn 3 points, deleting both 2's and the 4.
 * Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
 * 9 total points are earned.
 * Note:
 * <p>
 * The length of nums is at most 20000.
 * Each element nums[i] is an integer in the range [1, 10000].
 */
public class Delete_and_Earn_740 {
    public int deleteAndEarn3(int[] nums) {
        int[] sum = new int[10002];

        for (int i = 0; i < nums.length; i++) {
            sum[nums[i]] += nums[i];
        }

        for (int i = 2; i < sum.length; i++) {
            sum[i] = Math.max(sum[i - 1], sum[i - 2] + sum[i]);
        }
        return sum[10001];
    }

    public int deleteAndEarn2(int[] nums) {
        int[] count = new int[10001];
        for (int x : nums) count[x]++;
        int avoid = 0, using = 0, prev = -1;

        for (int k = 0; k <= 10000; ++k)
            if (count[k] > 0) {
                int m = Math.max(avoid, using);
                if (k - 1 != prev) {
                    using = k * count[k] + m;
                    avoid = m;
                } else {
                    using = k * count[k] + avoid;
                    avoid = m;
                }
                prev = k;
            }
        return Math.max(avoid, using);
    }

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        TreeSet<Integer> sorted = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!countMap.containsKey(nums[i])) {
                countMap.put(nums[i], 1);
                sorted.add(nums[i]);
            } else {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            }
        }
        int[] r = new int[sorted.size()];
        int[] v = new int[sorted.size()];
        Iterator<Integer> iterator = sorted.iterator();
        int i = 0;
        int max = 0;
        while (iterator.hasNext()) {
            v[i++] = iterator.next();
        }
        for (int j = 0; j < v.length; j++) {
            if (j == 0) r[j] = v[j] * countMap.get(v[j]);
            else if (j == 1) {
                r[j] = v[j] * countMap.get(v[j]);
                if (v[j - 1] + 1 != v[j]) r[j] += r[j - 1];
            } else {
                r[j] = v[j] * countMap.get(v[j]);
                if (v[j - 1] + 1 != v[j]) {
                    r[j] += Math.max(r[j - 1], r[j - 2]);
                } else {
                    if (j == 2)
                        r[j] += r[j - 2];
                    else
                        r[j] += Math.max(r[j - 2], r[j - 3]);
                }
            }
            if (r[j] > max)
                max = r[j];
        }
        return max;
    }
}
