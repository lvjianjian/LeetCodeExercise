/**
 * Created by zhongjianlv on 18-2-28.
 * <p>
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * For example,
 * <p>
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p>
 * Return the sum = 12 + 13 = 25.
 */
public class Sum_Root_to_Leaf_Numbers_129 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    private int helper(TreeNode c, int k){
        if(c == null) return 0;
        k *= 10;
        k += c.val;
        if(c.left == null && c.right == null) return k;
        return helper(c.left,k) + helper(c.right,k);
    }
}
