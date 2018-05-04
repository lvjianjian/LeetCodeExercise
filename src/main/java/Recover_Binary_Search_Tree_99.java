import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-2-28.
 * <p>
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 * <p>
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class Recover_Binary_Search_Tree_99 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private TreeNode t1 = null;
    private TreeNode t2 = null;
    private TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        find(root);
        t1.val ^= t2.val;
        t2.val ^= t1.val;
        t1.val ^= t2.val;
    }


    private void find(TreeNode c){
        if(c == null) {
            return;
        }
        find(c.left);
        if(pre != null && c.val < pre.val){
            if(t1 == null){
                t1 = pre;
                t2 = c;
            }else{
                t2 = c;
                return;
            }
        }
        pre = c;
        find(c.right);
    }

    public void recoverTree2(TreeNode root) {
        List<TreeNode> l = new ArrayList<>();
        helper(root,l);
        int i = 0;
        for(; i < l.size()-1; ++i){
            if(l.get(i).val > l.get(i+1).val)
                break;
        }
        for(int j = i+1; j <l.size()-1; ++j){
            if(l.get(j).val > l.get(j+1).val){
                l.get(i).val ^= l.get(j+1).val;
                l.get(j+1).val ^= l.get(i).val;
                l.get(i).val ^= l.get(j+1).val;
                return;
            }

        }

        l.get(i).val ^= l.get(i+1).val;
        l.get(i+1).val ^= l.get(i).val;
        l.get(i).val ^= l.get(i+1).val;


    }

    private void helper(TreeNode c, List<TreeNode> l){
        if(c == null) return;
        helper(c.left,l);
        l.add(c);
        helper(c.right,l);
    }

}
