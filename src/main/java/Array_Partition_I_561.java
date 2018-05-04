import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-1-4.
 * <p>
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Example 1:
 * Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 */
public class Array_Partition_I_561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

    //以空间换时间
    public int arrayPairSum2(int[] nums) {
        int[] exists = new int[20001];
        for (int num : nums) {
            exists[num+10000]++;
        }
        int sum = 0;
        boolean odd = true;
        for (int i = 0; i < 20001; i++) {
            while (exists[i] > 0) {
                if (odd) {
                    sum += i-10000;
                }
                odd = !odd;
                exists[i]--;
            }
        }
        return sum;
    }
}
