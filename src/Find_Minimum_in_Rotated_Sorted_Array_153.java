/**
 * Created by zhongjianlv on 2018/2/25
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class Find_Minimum_in_Rotated_Sorted_Array_153 {

    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.min(nums[0],nums[1]);
        int i = 0, j = n - 1;
        while(i < j){
            int mid = i + (j - i) / 2;
            if(mid == i)
                return Math.min(nums[i],nums[j]);
            if(nums[mid] > nums[i]){
                if(nums[mid] < nums[j])
                    j = mid - 1;
                else
                    i = mid + 1;
            }else{
                if(mid == 0)
                    return Math.min(nums[0],nums[1]);
                if(nums[mid] > nums[mid - 1]){
                    j = mid - 1;
                }else{
                    return nums[mid];
                }
            }
        }
        return nums[i];
    }
}
