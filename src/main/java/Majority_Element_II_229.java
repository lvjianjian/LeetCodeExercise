import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-3-11.
 * <p>
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
public class Majority_Element_II_229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> r = new ArrayList<>();
        if(nums.length == 0) return r;
        int num1 = nums[0],num2 = 0,count1 = 0,count2 = 0;
        for(int i = 0; i < nums.length; ++i){
            if(num1 == nums[i]) ++count1;
            else if(num2 == nums[i]) ++count2;
            else if(count1 == 0){
                num1 = nums[i];
                ++count1;
            }else if(count2 == 0){
                num2 = nums[i];
                ++count2;
            }else{
                --count1;
                --count2;
            }
        }

        count1 = count2 = 0;
        for(int i = 0;i < nums.length; ++i){
            if(nums[i] == num1)
                ++count1;
            else if(nums[i] == num2)
                ++count2;
        }
        if(count1 > nums.length / 3)
            r.add(num1);
        if(count2 > nums.length / 3)
            r.add(num2);

        return r;
    }
}
