/**
 * Created by zhongjianlv on 18-1-22.
 * <p>
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
public class Sort_Colors_75 {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = 0;
        while(i < nums.length && j >=0){
            while(k < nums.length && nums[k]==0) ++k;
            if(k == nums.length) break;
            if(nums[k] == 1){
                i = k+1;
                while(i < nums.length && nums[i]!=0) ++i;
                if(i == nums.length) break;
                nums[k] ^= nums[i];
                nums[i] ^= nums[k];
                nums[k] ^= nums[i];
            }else{
                while(j > k && nums[j]==2) --j;
                if(j == k) break;
                nums[k] ^= nums[j];
                nums[j] ^= nums[k];
                nums[k] ^= nums[j];
            }
        }
        j=nums.length-1;
        while(k < j){
            while(k < nums.length && nums[k] != 2) ++k;
            while(j > k && nums[j] != 1) --j;
            if(k < j){
                nums[k] ^= nums[j];
                nums[j] ^= nums[k];
                nums[k] ^= nums[j];
            }
        }

    }
}
