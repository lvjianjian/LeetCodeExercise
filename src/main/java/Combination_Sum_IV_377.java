import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-3-19.
 * <p>
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 * <p>
 * Example:
 * <p>
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * Note that different sequences are counted as different combinations.
 * <p>
 * Therefore the output is 7.
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
public class Combination_Sum_IV_377 {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] r = new int[target + 1];
        int j = 0;
        for (int i = 1; i <= target; i++) {
            for (int k = 0; k < j; k++) {
                r[i] += r[i - nums[k]];
            }
            if (j < nums.length && i == nums[j]) {
                r[i] += 1;
                ++j;
            }
        }
        return r[target];
    }

    public static void main(String[] args) {
        Combination_Sum_IV_377 combination_sum_iv_377 = new Combination_Sum_IV_377();
        System.out.println(combination_sum_iv_377.combinationSum4(new int[]{1,2,3},5));
    }
}
