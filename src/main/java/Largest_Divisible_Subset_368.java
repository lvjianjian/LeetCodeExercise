import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-4-27.
 * <p>
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1:
 * <p>
 * nums: [1,2,3]
 * <p>
 * Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * <p>
 * nums: [1,2,4,8]
 * <p>
 * Result: [1,2,4,8]
 */
public class Largest_Divisible_Subset_368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        int[] count = new int[nums.length];
        int[] pre = new int[nums.length];
        int max = 0;
        int lastMaxIndex = 0;
        int cMax = 0;
        int cIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            cMax = 0;
            cIndex = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (count[j] > cMax) {
                        cMax = count[j];
                        cIndex = j;
                    }
                }
            }
            count[i] = cMax + 1;
            pre[i] = cIndex;
            if (count[i] > max) {
                max = count[i];
                lastMaxIndex = i;
            }
        }


        do {
            res.add(0, nums[lastMaxIndex]);
            lastMaxIndex = pre[lastMaxIndex];
        } while (lastMaxIndex != -1);
        return res;
    }

    public static void main(String[] args) {
        Largest_Divisible_Subset_368 largest_divisible_subset_368 = new Largest_Divisible_Subset_368();
        System.out.println(largest_divisible_subset_368.largestDivisibleSubset(new int[]{1,2,3}));
    }
}
