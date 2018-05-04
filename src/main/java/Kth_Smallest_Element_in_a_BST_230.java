/**
 * Created by zhongjianlv on 2018/2/18
 * <p>
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class Kth_Smallest_Element_in_a_BST_230 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        return helper(root, new int[]{k});
    }

    private int helper(TreeNode c, int[] k) {
        if (c == null) return 0;

        int left = helper(c.left, k);
        if (k[0] == 0) return left;
        --k[0];
        if (k[0] == 0) return c.val;
        return helper(c.right, k);
    }
}
