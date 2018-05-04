/**
 * Created by zhongjianlv on 18-3-14.
 * <p>
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class Find_the_Duplicate_Number_287 {
    public int findDuplicate(int[] nums) {
        int i = 1;
        int j = nums.length - 1;
        while (i != j) {
            int mid = i + (j - i) / 2;
            int c = 0;
            for (int k = 0; k < nums.length; ++k) {
                if (nums[k] <= mid && nums[k] >= i)
                    ++c;
            }
            if (c > mid - i + 1) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}
