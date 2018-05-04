import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-4-25.
 * <p>
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * <p>
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * <p>
 * Input: [1, 2, 3, 5]
 * <p>
 * Output: false
 * <p>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class Partition_Equal_Subset_Sum_416 {

    //dfs2 按照从大到小排序
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = -nums[i];
        }
        if ((sum & 1) == 1) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
        return helper(nums, sum / 2, 0);
    }

    //dfs 超时
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) return false;
        Arrays.sort(nums);
        return helper(nums, sum / 2, 0);
    }

    private boolean helper(int[] nums, int target, int k) {
        if(k >= nums.length) return false;
        if (nums[k] == target) return true;
        else if (nums[k] > target) return false;
        else {
            if (helper(nums, target - nums[k], k + 1)) return true;
            if (helper(nums, target, k + 1)) return true;
        }
        return false;
    }
}
