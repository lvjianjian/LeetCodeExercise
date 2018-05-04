/**
 * Created by zhongjianlv on 2018/2/22
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example,
 * Given
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class Flatten_Binary_Tree_to_Linked_List_114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode current){
        if(current == null) return null;
        if(current.left == null && current.right == null) return current;
        TreeNode temp = current.right;
        TreeNode tail = null;
        if(current.left != null){
            tail = helper(current.left);
            tail.right = current.right;
            current.right = current.left;
            current.left = null;
        }
        if(temp != null)
            return helper(temp);
        else return tail;
    }
}
