/**
 * Created by zhongjianlv on 2018/2/18
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Missing_Number_268 {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; ++i){
            while(nums[i] < nums.length && nums[i] != i){
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != i)
                return i;
        }
        return nums.length;
    }
}
