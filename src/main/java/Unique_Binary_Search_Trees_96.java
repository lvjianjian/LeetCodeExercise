/**
 * Created by zhongjianlv on 18-2-5.
 * <p>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Unique_Binary_Search_Trees_96 {

    public int numTrees(int n) {
        int[] nums = new int[n + 2];
        nums[0] = 1;
        nums[1] = 1;
        int k = 2;
        while (k <= n) {
            helper(k++, nums);
        }

        return nums[n];
    }

    private void helper(int k, int[] nums) {
        for (int i = 0; i < k; i++) {
            nums[k] += (nums[i] * nums[k - i - 1]);
        }
    }
}
