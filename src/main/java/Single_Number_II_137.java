/**
 * Created by zhongjianlv on 2018/2/23
 * <p>
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Single_Number_II_137 {
    public int singleNumber(int[] nums) {
        int a=0,b=0;
        for(int c:nums){
            int temp = (~a&b&c) | (a&~b&~c);
            b = (~a&~b&c) | (~a&b&~c);
            a = temp;
        }
        return b;
    }

}
