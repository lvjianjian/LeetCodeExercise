/**
 * Created by zhongjianlv on 2018/2/25
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Move_Zeroes_283 {
    //不做交换，直接赋值，最后剩下的赋0
    public void moveZeroes(int[] nums) {
        if(nums.length < 2) return;
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for(;k < nums.length; k++)
            nums[k] = 0;
    }

    public void moveZeroes2(int[] nums) {
        int i = 0, j =0;
        while(i < nums.length){
            if(nums[i] == 0){
                j = i + 1;
                while(j < nums.length && nums[j] == 0){
                    ++j;
                }
                if(j < nums.length){
                    nums[i] ^= nums[j];
                    nums[j] ^= nums[i];
                    nums[i] ^= nums[j];
                }else{
                    return;
                }
            }
            ++i;
        }
    }
}
