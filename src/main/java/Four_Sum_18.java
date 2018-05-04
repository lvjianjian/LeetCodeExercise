import java.util.*;

/**
 * Created by zhongjianlv on 17-4-11.
 * <p>
 * leetcode algorithm 18
 * <p>
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target
 * <p>
 * Note: The solution set must not contain duplicate quadruplets.
 * <p>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class Four_Sum_18 {

    public void find(int[] nums, int i, int j, int target, List<List<Integer>> res) {
        int l = j + 1;
        int h = nums.length - 1;
        int _temp = target - nums[i] - nums[j];
        while (l < h) {
            if (nums[l] + nums[h] == _temp) {
                LinkedList<Integer> integers = new LinkedList<>();
                integers.add(nums[i]);
                integers.add(nums[j]);
                integers.add(nums[l]);
                integers.add(nums[h]);
                res.add(integers);
                while (l < h && nums[l] == nums[l + 1])
                    ++l;
                ++l;
                while (l < h && nums[h] == nums[h - 1])
                    --h;
                --h;


            } else if (nums[l] + nums[h] > _temp) {
                --h;
            } else
                ++l;
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                find(nums, i, j, target, res);
                while (j < nums.length - 2 && nums[j] == nums[j + 1])
                    ++j;
            }
            while (i < nums.length - 3 && nums[i] == nums[i + 1])
                ++i;
        }
        return res;
    }


    public static void main(String[] args) {
        Four_Sum_18 four_sum_18 = new Four_Sum_18();
        four_sum_18.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
    }

}

