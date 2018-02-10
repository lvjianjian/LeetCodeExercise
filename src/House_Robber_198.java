/**
 * Created by zhongjianlv on 2018/2/10
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class House_Robber_198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        int[] max = new int[n];
        max[0] = nums[0];
        max[1] = nums[1];
        max[2] = nums[0] + nums[2];
        for(int i = 3; i < n; ++i){
            max[i] = Math.max(max[i-2],max[i-3]) + nums[i];
        }
        return Math.max(max[n-1],max[n-2]);
    }
}
