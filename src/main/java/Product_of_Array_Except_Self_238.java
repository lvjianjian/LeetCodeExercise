/**
 * Created by zhongjianlv on 18-3-10.
 * <p>
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 */
public class Product_of_Array_Except_Self_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] r = new int[nums.length];
        int all = 1;
        int zero_index = -1;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0){
                if(zero_index >= 0)
                    return r;
                else zero_index = i;
            }else all *= nums[i];
        }
        if(zero_index > 0){
            r[zero_index] = all;
        }else{
            for(int i = 0 ; i < nums.length; ++i)
                r[i] = all / nums[i];
        }
        return r;
    }
}
