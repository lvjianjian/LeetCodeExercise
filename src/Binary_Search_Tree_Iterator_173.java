/**
 * Created by zhongjianlv on 18-3-2.
 * <p>
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class Binary_Search_Tree_Iterator_173 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode c;
    private TreeNode r;
    public Binary_Search_Tree_Iterator_173(TreeNode root) {
        r = root;
        c = null;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        TreeNode root = r;
        if(root == null) return false;
        if(c == null) {
            while(root.left != null){
                root = root.left;
            }
            c = root;
        }else{
            if(c.right != null){
                c = c.right;
                while(c.left!=null){
                    c = c.left;
                }
            }else{
                TreeNode temp = null;
                TreeNode cu = root;
                while(cu != c){
                    if(c.val <= cu.val){
                        temp = cu;
                        cu = cu.left;
                    }else{
                        cu = cu.right;
                    }
                }
                c = temp;
            }
        }

        if(c == null) return false;
        else return true;
    }

    /** @return the next smallest number */
    public int next() {
        return c.val;
    }
}
