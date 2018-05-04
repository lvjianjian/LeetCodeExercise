/**
 * Created by zhongjianlv on 2018/2/12
 * <p>
 * <p>
 * Note: This is an extension of House Robber.
 * <p>
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class House_Robber_II_213 {
    //包含j与不包含j
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 1, nums.length - 1), rob(nums, 0, nums.length - 2));
    }

    private int rob(int[] nums, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        if(n == 3) return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        int[] r = new int[n];
        int[] t = new int[n];
        r[0] = nums[0];
        r[1] = nums[1];
        r[2] = nums[0] + nums[2];
        t[0] = 1;
        t[1] = 0;
        t[2] = 1;
        int max = 0;
        for(int i = 3; i < n-1; ++i){
            if(r[i-3] > r[i-2]){
                r[i] = r[i-3] + nums[i];
                t[i] = t[i-3];
            }else{
                r[i] = r[i-2] + nums[i];
                t[i] = t[i-2];
            }
        }

        if(t[n-3] == 0 && t[n-4] == 0){
            r[n-1] = Math.max(r[n-3],r[n-4]) + nums[n-1];
            return Math.max(r[n-1],r[n-2]);
        }else if(t[n-3] == 0 || t[n-4] == 0){
            if(t[n-3] == 0){
                r[n-1] = r[n-3] + nums[n-1];
            }else{
                r[n-1] = r[n-4] + nums[n-1];
            }
            return Math.max(Math.max(r[n-3],r[n-4]),Math.max(r[n-1],r[n-2]));
        }else{
            max = Math.max(r[n-2],r[n-3]);
            r[0] = nums[n-1];
            r[1] = nums[n-2];
            r[2] = nums[n-1] + nums[n-3];
            for(int i = n - 4; i > 0; --i){
                r[n - i - 1] = Math.max(r[n-i-3],r[n-i-4]) + nums[i];
            }
            max = Math.max(Math.max(max, r[n-2]),r[n-3]);
            return max;
        }
    }
}
