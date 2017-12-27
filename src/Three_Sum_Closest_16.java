import java.util.Arrays;

/**
 * Created by zhongjianlv on 17-4-10.
 * <p>
 * leetcode algorithm 16
 * <p>
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Three_Sum_Closest_16 {


    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        int old_abs = Math.abs(res - target);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]){
                int lo = i + 1;
                int hi = nums.length - 1;
                int new_target = target - nums[i];
                while (lo < hi){
                    if(Math.abs(new_target - nums[lo] - nums[hi]) < old_abs){
                        old_abs = Math.abs(new_target - nums[lo] - nums[hi]);
                        res = nums[i] + nums[hi] + nums[lo];
                    }
                    if(nums[lo] + nums[hi] == new_target){
                        return target;
                    }
                    else if (nums[lo] + nums[hi] < new_target) {
                        lo++;
                    }
                    else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }


    /**
     * O(n^3) time limited
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest1(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int r = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - r) < Math.abs(target - res))
                        res = r;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Three_Sum_Closest_16 threeSumClosest16 = new Three_Sum_Closest_16();
        System.out.println(threeSumClosest16.threeSumClosest(new int[]{0,2,1,-3},1));
    }

}
