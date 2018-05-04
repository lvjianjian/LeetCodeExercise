import java.util.Stack;

/**
 * Created by zhongjianlv on 18-2-5.
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class Symmetric_Tree_101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {//iteratively
        if(root == null) return true;
        Stack<TreeNode> stacks = new Stack<>();
        stacks.push(root.left);
        stacks.push(root.right);
        TreeNode n1 = null ,n2 = null;
        while(!stacks.isEmpty()){
            n1 = stacks.pop();
            if(stacks.isEmpty()) return false;
            n2 = stacks.pop();
            if(n1 == null && n2 == null)
                continue;
            if(n1 == null || n2 == null)
                return false;
            if(n1.val != n2.val) return false;
            stacks.push(n1.left);
            stacks.push(n2.right);
            stacks.push(n1.right);
            stacks.push(n2.left);
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {//recursively
        if (root == null) return true;
        return helper(root.left, root.right);
    }


    private boolean helper(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val == n2.val) return helper(n1.left, n2.right) && helper(n1.right, n2.left);
        else return false;
    }
}
