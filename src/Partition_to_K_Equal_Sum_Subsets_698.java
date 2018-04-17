import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhongjianlv on 18-4-17.
 * <p>
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * <p>
 * Example 1:
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Note:
 * <p>
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
public class Partition_to_K_Equal_Sum_Subsets_698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int all = 0;
        for (int i = 0; i < nums.length; i++) {
            all += nums[i];
            nums[i] = -nums[i];
        }
        int equal = all / k;
        if (equal * k != all) return false;
        int[] temp = new int[k];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
        if (nums[0] > equal) return false;
        return dfs(nums, 0, temp, equal);
    }


    /**
     * 对nums中的数字从大到小排序可以加大剪枝力度
     */
    private boolean dfs(int[] nums, int i, int[] temp, int v) {
        if (i == nums.length) {
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] != v) return false;
            }
            return true;
        }

        for (int j = 0; j < temp.length; j++) {
            temp[j] += nums[i];
            if (temp[j] <= v)
                if (dfs(nums, i + 1, temp, v)) return true;
            temp[j] -= nums[i];
            if (temp[j] == 0) break;// 对第j个位置没有方案可以使它和为v, 则不可能有方案
        }
        return false;
    }


    public static void main(String[] args) {
        Partition_to_K_Equal_Sum_Subsets_698 partition_to_k_equal_sum_subsets_698 = new Partition_to_K_Equal_Sum_Subsets_698();
        System.out.println(partition_to_k_equal_sum_subsets_698.canPartitionKSubsets(new int[]{7628,
                        3147,
                        7137,
                        2578,
                        7742,
                        2746,
                        4264,
                        7704,
                        9532,
                        9679,
                        8963,
                        3223,
                        2133,
                        7792,
                        5911,
                        3979},
                6));
    }
}
