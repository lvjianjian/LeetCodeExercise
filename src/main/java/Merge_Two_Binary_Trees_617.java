/**
 * Created by zhongjianlv on 18-1-4.
 * <p>
 * <p>
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 */
public class Merge_Two_Binary_Trees_617 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            mergeTrees(t1.left, t2.left);
            mergeTrees(t1.right, t2.right);

            if (t1.left == null)
                t1.left = t2.left;

            if (t1.right == null)
                t1.right = t2.right;
        }

        if(t1 == null)
            return t2;
        return t1;
    }


}
