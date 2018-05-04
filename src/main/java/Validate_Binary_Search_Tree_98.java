import java.util.Stack;

/**
 * Created by zhongjianlv on 18-2-5.
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * 2
 * / \
 * 1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 * 1
 * / \
 * 2   3
 * Binary tree [1,2,3], return false.
 */
public class Validate_Binary_Search_Tree_98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return isValidWithBound(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidWithBound(TreeNode root, double low, double high){
        if(root == null) return true;
        if(root.val <= low || root.val >= high) return false;
        return isValidWithBound(root.left, low, root.val) && isValidWithBound(root.right, root.val, high);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stacks = new Stack<>();
        stacks.push(root);
        TreeNode current = root;
        int pre = Integer.MIN_VALUE;
        boolean first = true;
        while (!stacks.isEmpty()) {
            if (current != null) {
                stacks.push(current.left);
                current = current.left;
            } else {
                stacks.pop();
                if (stacks.isEmpty())
                    break;
                current = stacks.pop();
                if (first) {
                    pre = current.val;
                    first = false;
                } else {
                    if (pre >= current.val)
                        return false;
                    pre = current.val;
                }

                stacks.push(current.right);
                current = current.right;

            }
        }
        return true;
    }
}
