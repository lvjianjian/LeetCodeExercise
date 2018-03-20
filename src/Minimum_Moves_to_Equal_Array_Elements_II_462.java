import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-3-19.
 * <p>
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * <p>
 * You may assume the array's length is at most 10,000.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class Minimum_Moves_to_Equal_Array_Elements_II_462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int r = 0;
        int i = 0, j = nums.length - 1;
        while (i < j){
            r += (nums[j--] - nums[i++]);
        }
        return r;
    }
}
