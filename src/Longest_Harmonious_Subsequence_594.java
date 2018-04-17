import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongjianlv on 18-4-17.
 * <p>
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 * <p>
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Note: The length of the input array will not exceed 20,000.
 */
public class Longest_Harmonious_Subsequence_594 {
    public int findLHS(int[] nums) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        int k = 0;
        int i = 1;
        int max = 0;

        while (i < nums.length && nums[i] == nums[i - 1]) {
            ++i;
        }
        int j = i + 1;
        while (j <= nums.length) {
            while (j < nums.length && nums[j] == nums[j - 1]) {
                ++j;
            }
            if (nums[i - 1] == nums[j - 1] - 1) {
                max = Math.max(j - k, max);
            }
            k = i;
            i = j;
            ++j;
        }
        return max;
    }
}
