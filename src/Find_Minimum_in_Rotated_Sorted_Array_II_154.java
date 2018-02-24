/**
 * Created by zhongjianlv on 2018/2/25
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 */
public class Find_Minimum_in_Rotated_Sorted_Array_II_154 {

    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int min = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] < min)
                min = nums[i];
        }
        return min;
    }
}
