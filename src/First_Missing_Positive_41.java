import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-1-8.
 *
 *
 */
public class First_Missing_Positive_41 {

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int l = nums.length;
        while(i < l){
            if(nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length || nums[nums[i] - 1] == nums[i]){
                ++i;
            }else{
                int k = nums[i] - 1;
                nums[k] ^= nums[i];
                nums[i] ^= nums[k];
                nums[k] ^= nums[i];
            }
        }

        i = 0;
        while(i < l){
            if (nums[i] != i+1)
                break;
            ++i;
        }
        return i+1;
    }


}
