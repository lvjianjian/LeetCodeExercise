import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-4-22.
 * <p>
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class Minimum_Moves_to_Equal_Array_Elements_453 {


    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 1) return 0;
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
            min = Math.min(min, nums[i]);
        }
        return res - nums.length * min;
    }

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 1) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res += (nums[i] - nums[0]);
        }
        return res;
    }
}
