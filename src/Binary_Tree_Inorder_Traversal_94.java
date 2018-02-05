import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhongjianlv on 18-2-5.
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Binary_Tree_Inorder_Traversal_94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper2(root, result);
        return result;
    }

    //Iteratively
    private void helper2(TreeNode root, List<Integer> result) {
        if (root == null) return;
        Stack<TreeNode> stacks = new Stack<>();
        stacks.push(root);
        TreeNode current = root;
        while (!stacks.isEmpty()) {
            if (current != null) {
                stacks.push(current.left);
                current = current.left;
            } else {
                stacks.pop(); // remvoe null
                if (stacks.isEmpty()) break;
                current = stacks.pop();
                result.add(current.val);
                stacks.push(current.right);
                current = current.right;
            }
        }
    }

    //Recursive
    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }


    public static void main(String[] args) {
        Stack<TreeNode> stacks = new Stack<>();
        stacks.push(null);
        stacks.push(null);
        System.out.println(stacks.size());
        TreeNode pop = stacks.pop();
        System.out.println(pop);
        System.out.println(stacks.size());
    }
}
