import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by zhongjianlv on 18-4-19.
 * <p>
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class K_diff_Pairs_in_an_Array_532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0 || nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> pasted = new HashMap<>();
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pasted.containsKey(nums[i])) {
                if (k == 0) {
                    if (pasted.get(nums[i]) == 1) ++n;
                    pasted.put(nums[i], 2);
                }
                continue;
            }
            pasted.put(nums[i], 1);
            if (k != 0) {
                if (pasted.containsKey(nums[i] + k)) ++n;
                if (pasted.containsKey(nums[i] - k)) ++n;
            }
        }
        return n;
    }

    public int findPairs2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        HashSet<Integer> pasted = new HashSet<>();
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pasted.contains(nums[i] - k)) {
                ++n;
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) ++i;
            }
            pasted.add(nums[i]);
        }
        return n;
    }
}
