
/**
 * Created by zhongjianlv on 2018/5/7
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Diameter_of_Binary_Tree_543 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }

    private int helper(TreeNode c) {
        if (c == null) return 0;
        int l = helper(c.left);
        int r = helper(c.right);
        if (c.left != null) ++l;
        if (c.right != null) ++r;
        if (l + r > max) max = l + r;
        return Math.max(l, r);
    }
}
