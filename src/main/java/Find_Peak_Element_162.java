/**
 * Created by zhongjianlv on 2018/2/14
 * <p>
 * A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that num[-1] = num[n] = -∞.
 * <p>
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class Find_Peak_Element_162 {
    public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length - 1; ++i){
            if(nums[i] - nums[i+1] > 0)
                return i;
        }
        return nums.length - 1;
    }
}
