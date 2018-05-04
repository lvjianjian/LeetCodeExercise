/**
 * Created by zhongjianlv on 18-1-16.
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */
public class Jump_Game_55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i <= max; ++i) {
            if (max >= nums.length - 1)
                return true;
            max = Math.max(max, i + nums[i]);
        }
        return false;
    }
}
