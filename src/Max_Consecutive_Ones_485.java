/**
 * Created by zhongjianlv on 18-1-8.
 * <p>
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class Max_Consecutive_Ones_485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ++current;
            } else {
                if (current > max)
                    max = current;
                current = 0;
                if (i + max + 1 >= nums.length)
                    break;

            }
        }

        if (current > max)
            max = current;

        return max;
    }
}
