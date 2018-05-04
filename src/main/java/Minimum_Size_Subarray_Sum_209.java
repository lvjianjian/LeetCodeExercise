/**
 * Created by zhongjianlv on 2018/2/11
 * <p>
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class Minimum_Size_Subarray_Sum_209 {

    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        int st = 0, e = 0;
        int n = nums.length;
        int sum = 0;
        while (st != n) {
            sum += nums[st++];
            while (sum >= s) {
                flag = true;
                min = Math.min(min, st - e);
                sum -= nums[e++];
            }
        }
        if (flag)
            return min;
        else return 0;
    }
}
