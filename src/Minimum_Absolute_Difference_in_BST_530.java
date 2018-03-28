import sun.reflect.generics.tree.Tree;

/**
 * Created by zhongjianlv on 18-3-28.
 * <p>
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 */
public class Minimum_Absolute_Difference_in_BST_530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode pre = null;
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return min;
    }

    private void helper(TreeNode c) {
        if (c == null) return;
        helper(c.left);
        if (pre != null) {
            int cha = c.val - pre.val;
            if (cha < min) min = cha;
        }
        pre = c;
        helper(c.right);
    }

}
