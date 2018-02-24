/**
 * Created by zhongjianlv on 2018/2/24
 * <p>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class Maximum_Product_Subarray_152 {
    public int maxProduct(int[] nums) {
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        int c = 1;
        while(j < nums.length){
            while(i < nums.length && nums[i] != 0){
                c *= nums[i];
                if(c > max)
                    max = c;
                ++i;
            }
            while(i > j + 1){
                c /= nums[j];
                if(c > max)
                    max = c;
                ++j;
            }
            j = i;
            if(i < nums.length){
                if(0 > max)
                    max = 0;
                c = 1;
                ++i;
                ++j;

            }
        }
        return max;
    }
}
