/**
 * Created by zhongjianlv on 18-3-14.
 * <p>
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * <p>
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 * <p>
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * Output:
 * 18
 * <p>
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class Split_Array_Largest_Sum_410 {

    private long max = Integer.MAX_VALUE;

    public int splitArray(int[] nums, int m) {
        max = Integer.MAX_VALUE;
        long alls = 0;
        for (int i = 0; i < nums.length; i++) {
            alls += nums[i];
        }
        helper2(nums, m, 0, alls, 0);
        return (int) max;
    }


    private void helper2(int[] nums, int m, long current_max, long alls, int start) {
        if (alls == 0) return;
        if (m == 1) {
            current_max = Math.max(current_max, alls);
            if (current_max < max) max = current_max;
            return;
        }
        if (current_max > max) return;
        double average = (double) alls / m;
        int i = start;
        long current_all_sum = 0;
        for (; i < nums.length; i++) {
            current_all_sum += nums[i];
            if (current_all_sum > average) break;
        }
        helper2(nums, m - 1, Math.max(current_max, current_all_sum - nums[i]), alls - current_all_sum + nums[i], i);
        helper2(nums, m - 1, Math.max(current_max, current_all_sum), alls - current_all_sum, i + 1);
    }

    private int helper(int[] nums, int m, int alls, int start) {
        if (alls == 0) return Integer.MAX_VALUE;
        if (m == 1) return alls;
        double average = (double) alls / m;
        int current_all_sum = 0;
        int i = start;
        for (; i < nums.length; i++) {
            current_all_sum += nums[i];
            if (current_all_sum > average) break;
        }
        int c1 = Math.max(current_all_sum, helper(nums, m - 1, alls - current_all_sum, i + 1));
        int c2 = Math.max(current_all_sum - nums[i], helper(nums, m - 1, alls - current_all_sum + nums[i], i));
        return Math.min(c1, c2);
    }

    public static void main(String[] args) {
        Split_Array_Largest_Sum_410 split_array_largest_sum_410 = new Split_Array_Largest_Sum_410();
        System.out.println(split_array_largest_sum_410.splitArray(new int[]{1, 2147483647}, 2));
    }
}
