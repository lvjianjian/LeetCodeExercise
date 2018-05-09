/**
 * Created by zhongjianlv on 2018/5/9
 * <p>
 * <p>
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Output:
 * 1
 * Example 2:
 * Input:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * Output:
 * 7
 */
public class Find_Bottom_Left_Tree_Value_513 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int deep;
    private int value;

    public int findBottomLeftValue(TreeNode root) {
        deep = 0;
        value = 0;
        helper(root, 1);
        return value;
    }

    private void helper(TreeNode c, int d) {
        if (c == null) return;
        if (c.left == null && d > deep) {
            deep = d;
            value = c.val;
        }
        helper(c.left, d + 1);
        helper(c.right, d + 1);
    }
}
