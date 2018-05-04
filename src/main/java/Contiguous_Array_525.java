import java.util.Stack;

/**
 * Created by zhongjianlv on 18-3-16.
 * <p>
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class Contiguous_Array_525 {
    public int findMaxLength(int[] nums) {
        int[] r = new int[nums.length];
        int max = 0;
        Stack<Integer> zeros = new Stack<>();
        Stack<Integer> ones = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {//0
                if (!ones.isEmpty()) {
                    r[i] = ones.pop();
                } else r[i] = -1;
                zeros.push(i);
            } else {//1
                if (!zeros.isEmpty())
                    r[i] = zeros.pop();
                else r[i] = -1;
                ones.push(i);
            }
        }

        for (int i = 0; i < r.length; i++) {
            if (r[i] > 0) {
                r[i] = (i - r[i] + 1 + r[r[i] - 1]);
            } else if (r[i] == 0) {
                r[i] = i - r[i] + 1;
            } else {
                r[i] = 0;
            }
            if(r[i] > max)
                max = r[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Contiguous_Array_525 contiguous_array_525 = new Contiguous_Array_525();
        System.out.println(contiguous_array_525.findMaxLength(new int[]{0, 1}));
    }
}
