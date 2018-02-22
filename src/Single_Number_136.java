/**
 * Created by zhongjianlv on 2018/2/23
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Single_Number_136 {

    public int singleNumber(int[] nums) {
        int r = 0;
        for(int i = 0;i < nums.length; ++i){
            r ^= nums[i];
        }
        return r;
    }
}
