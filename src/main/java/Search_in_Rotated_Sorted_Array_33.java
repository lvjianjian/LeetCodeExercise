/**
 * Created by zhongjianlv on 17-12-29.
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class Search_in_Rotated_Sorted_Array_33 {

    // 我是先找到pivot， 可以先拿mid 和right比（这里没想到）, 然后在用target和mid,right/left比
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int l = 0;
        int h = nums.length - 1;
        int split = 0;
        while (l <= h) {
            int m = (l + h) / 2;
            int v1 = nums[m];
            if (m + 1 >= nums.length) {
                split = m;
                break;
            }
            int v2 = nums[m + 1];
            if (v1 >= nums[0] && v2 >= nums[0])
                l = m + 1;
            else if (v1 <= nums[0] && v2 <= nums[0])
                h = m - 1;
            else {
                split = (l + h) / 2;
                break;
            }

        }


        if (target <= nums[split] && target >= nums[0]) {
            l = 0;
            h = split;
        } else {
            l = split + 1;
            h = nums.length - 1;
        }
        while (l <= h) {
            int m = (l + h) / 2;
            int v = nums[m];
            if (v > target) {
                h = m - 1;
            } else if (v < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array_33 search_in_rotated_sorted_array_33 = new Search_in_Rotated_Sorted_Array_33();
        System.out.println(search_in_rotated_sorted_array_33.search(new int[]{4, 5, 0, 1, 2, 3, 4}, -1));
    }
}
