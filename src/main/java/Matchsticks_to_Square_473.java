import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-5-18.
 * <p>
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
 * <p>
 * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 * <p>
 * Example 1:
 * Input: [1,1,2,2,2]
 * Output: true
 * <p>
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * Example 2:
 * Input: [3,3,3,3,4]
 * Output: false
 * <p>
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * Note:
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 */
public class Matchsticks_to_Square_473 {

    public boolean makesquare(int[] nums) {
        int length = nums.length;
        if(length == 0) return false;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            nums[i] = -nums[i];
        }
        if(sum % 4 !=0) return false;
        int l = sum / 4;//边长
        Arrays.sort(nums);
        return helper(nums,new int[4],0,l);
    }

    private boolean helper(int[] nums, int[] edges, int index,int l){
        if(index == nums.length) return true;
        for (int i = 0; i < edges.length; i++) {
            edges[i] -= nums[index];//nums为负数所以-
            if(edges[i] <= l)
                if(helper(nums,edges,index+1,l))
                    return true;
            edges[i] += nums[index];
        }
        return false;
    }


}
