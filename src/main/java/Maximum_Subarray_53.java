/**
 * Created by zhongjianlv on 18-1-9.
 * <p>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class Maximum_Subarray_53 {
    public int maxSubArray(int[] nums) {
        if(nums.length==1)return nums[0];
        int result=nums[0];
        int re=nums[0];
        for (int i = 1; i < nums.length; i++) {
            result=Math.max(result+nums[i], nums[i]);
            if(result>re){
                re=result;
            }
        }
        return re;
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];
            if (nums[i] > current)
                current = nums[i];
            if (current > max)
                max = current;
            if (current >= 0) {
                while (++i < nums.length && current + nums[i] > 0) {
                    current += nums[i];
                    if (current > max)
                        max = current;
                }
            }

            if (current > max)
                max = current;
        }

        if (current > max)
            max = current;
        return max;
    }

    public static void main(String[] args) {
        Maximum_Subarray_53 maximum_subarray_53 = new Maximum_Subarray_53();
        System.out.println(maximum_subarray_53.maxSubArray(new int[]{-3,2,-1}));
    }
}
