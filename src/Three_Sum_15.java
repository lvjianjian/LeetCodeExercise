
import java.util.*;

/**
 * Created by zhongjianlv on 17-4-6.
 * <p>
 * leetcode algorithm 15
 * <p>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Three_Sum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int _temp = 0 - nums[i];

            int l = i + 1;
            int h = nums.length - 1;
            while (l < h) {
                if (nums[l] + nums[h] == _temp) {
                    LinkedList<Integer> integers = new LinkedList<>();
                    integers.add(nums[i]);
                    integers.add(nums[l]);
                    integers.add(nums[h]);
                    res.add(integers);
                    while (l < h && nums[l] == nums[l + 1])
                        ++l;
                    ++l;
                    while (l < h && nums[h] == nums[h - 1])
                        --h;
                    --h;

                } else if (nums[l] + nums[h] < _temp)
                    ++l;
                else {
                    --h;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                ++i;
        }
        return res;
    }



    public static void main(String[] args) {
    }
}
