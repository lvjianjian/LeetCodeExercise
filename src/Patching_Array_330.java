import java.util.*;

/**
 * Created by zhongjianlv on 18-3-14.
 * <p>
 * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
 * <p>
 * Example 1:
 * nums = [1, 3], n = 6
 * Return 1.
 * <p>
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 * So we only need 1 patch.
 * <p>
 * Example 2:
 * nums = [1, 5, 10], n = 20
 * Return 2.
 * The two patches can be [2, 4].
 * <p>
 * Example 3:
 * nums = [1, 2, 2], n = 5
 * Return 0.
 */
public class Patching_Array_330 {
    public int minPatches(int[] nums, int n) {
        int add = 0;
        long max = 0;
        int i = 0;
        while (max < n) {
            if (i == nums.length || nums[i] > max + 1) {
                ++add;
                max = 2 * max + 1;
            } else {
                max = max + nums[i];
                ++i;
            }
            if (max >= n) break;
        }
        return add;
    }


    public static void main(String[] args) {
        Patching_Array_330 patching_array_330 = new Patching_Array_330();
        System.out.println(patching_array_330.minPatches(new int[]{1, 5, 10}, 20));
    }


}
