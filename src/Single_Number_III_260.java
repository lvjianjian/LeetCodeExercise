/**
 * Created by zhongjianlv on 2018/2/17
 * <p>
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * For example:
 * <p>
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * <p>
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class Single_Number_III_260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num:nums){
            diff ^= num;
        }
        diff &= -diff;
        int r[] = new int[2];
        for(int num:nums)
        {
            if((num & diff) == 0){
                r[0] ^= num;
            }else{
                r[1] ^= num;
            }
        }
        return r;
    }
}
