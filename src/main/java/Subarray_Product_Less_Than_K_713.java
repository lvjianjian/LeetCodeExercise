/**
 * Created by zhongjianlv on 18-3-20.
 * <p>
 * Your are given an array of positive integers nums.
 * <p>
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * <p>
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Note:
 * <p>
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 */
public class Subarray_Product_Less_Than_K_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int s = 0, e = 0;
        int r = 0;
        long p = 1;
        while (s < nums.length) {
            p *= nums[s];
            if (p < k) {
                r += (s - e + 1);
            } else {
                while (e < s && p >= k) {
                    p /= nums[e++];
                }
                if (p < k)
                    r += (s - e + 1);
            }
            ++s;
        }
        return r;
    }
}
