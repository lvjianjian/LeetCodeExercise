import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by zhongjianlv on 18-1-8.
 * <p>
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.
 * <p>
 * Example 1:
 * Input: 12
 * Output: 21
 * Example 2:
 * Input: 21
 * Output: -1
 */
public class Next_Greater_Element_III_556 {

    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) --i;
        if (i < 0)
            return -1;
        else {
            int j = nums.length - 1;
            for (; j > i; --j) {
                if (nums[j] > nums[i])
                    break;
            }
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];

            Arrays.sort(nums, i + 1, nums.length);
        }
        try {
            return Integer.valueOf(new String(nums));
        } catch (Exception e) {
            return -1;
        }
    }


    public static void main(String[] args) {
        Next_Greater_Element_III_556 next_greater_element_iii_556 = new Next_Greater_Element_III_556();
        System.out.println(next_greater_element_iii_556.nextGreaterElement(54321));
    }
}
