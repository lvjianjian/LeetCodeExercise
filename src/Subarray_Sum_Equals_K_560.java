import java.util.HashMap;

/**
 * Created by zhongjianlv on 18-4-21.
 * <p>
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class Subarray_Sum_Equals_K_560 {
    public int subarraySum(int[] nums, int k) {
        //存放前缀和以及前缀和的个数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            res += map.getOrDefault(prefixSum - k, 0);
            //更新前缀和map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}
