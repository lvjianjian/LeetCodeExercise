import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhongjianlv on 18-3-7.
 * <p>
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree [1,null,2,3],
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * <p>
 * return [3,2,1].
 */
public class Binary_Tree_Postorder_Traversal_145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> r = new LinkedList<>();
        if(root == null) return r;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            r.add(0,temp.val);
            if(temp.left != null)
                stack.push(temp.left);
            if(temp.right != null)
                stack.push(temp.right);
        }
        return r;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> r = new LinkedList<>();
        if(root == null) return r;
        Stack<TreeNode> stacks = new Stack<>();
        TreeNode c = root;
        while(!stacks.isEmpty() || c != null){
            r.add(0,c.val);
            if(c.right != null){
                stacks.add(c);
                c = c.right;
            }else{
                if(c.left != null){
                    c = c.left;
                }else{
                    while(c.left == null && !stacks.isEmpty()){
                        c = stacks.pop();
                    }
                    c = c.left;

                }
            }
        }
        return r;
    }



    //递归
    private void helper(TreeNode c, List<Integer> r) {
        if (c != null) {
            helper(c.left, r);
            helper(c.right, r);
            r.add(c.val);
        }
    }
}
