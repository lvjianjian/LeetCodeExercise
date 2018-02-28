/**
 * Created by zhongjianlv on 18-2-28.
 * <p>
 * Given a binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * For example:
 * Given the below binary tree,
 * <p>
 * 1
 * / \
 * 2   3
 * Return 6.
 */
public class Binary_Tree_Maximum_Path_Sum_124 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }


    private int helper(TreeNode c) {
        if (c == null) return 0;
        int left = helper(c.left);
        int right = helper(c.right);
        if (left + right + c.val > max)
            max = left + right + c.val;
        int k = 0;
        if (left > right)
            k = left;
        else k = right;
        k += c.val;
        if (k < 0) k = 0;
        return k;
    }

}
