import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhongjianlv on 18-3-7.
 * <p>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,2,3].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Binary_Tree_Preorder_Traversal_144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        if (root == null) return r;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            r.add(temp.val);
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
        return r;
    }


    //递归
    private void helper(TreeNode c, List<Integer> r) {
        if (c != null) {
            r.add(c.val);
            helper(c.left, r);
            helper(c.right, r);
        }
    }
}
