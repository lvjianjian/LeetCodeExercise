import java.util.Arrays;

/**
 * Created by zhongjianlv on 17-12-28.
 * <p>
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * <p>
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * <p>
 * return [3, 4].
 */
public class Search_for_a_Range_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int l = 0;
        int h = nums.length - 1;
        int[] res = new int[2];
        while ((h - l) > 1) {
            int m = (l + h) / 2;
            if (nums[m] < target)
                l = m;
            else
                h = m;
        }

        if (nums[l] > target)
            res[0] = -1;
        else if (nums[l] == target)
            res[0] = l;
        else if ((nums[l] < target) && (nums[h] > target))
            res[0] = -1;
        else if (nums[h] == target)
            res[0] = h;
        else
            res[0] = -1;

        if (res[0] == -1)
            res[1] = -1;
        else {
            l = res[0];
            h = nums.length - 1;
            while ((h - l) > 1) {
                int m = (l + h) / 2;
                if (nums[m] <= target)
                    l = m;
                else
                    h = m;
            }
            if(nums[h] == target)
                res[1] = h;
            else
                res[1] = l;
        }
        return res;
    }

    public static void main(String[] args) {
        Search_for_a_Range_34 search_for_a_range_34 = new Search_for_a_Range_34();
        System.out.println(Arrays.toString(search_for_a_range_34.searchRange(new int[]{8,8,1}, 8)));
    }
}
