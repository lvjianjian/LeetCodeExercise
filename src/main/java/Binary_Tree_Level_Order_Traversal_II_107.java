import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-2-6.
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class Binary_Tree_Level_Order_Traversal_II_107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        List<TreeNode> nodes = new ArrayList<>();
        int current = 0;
        int all = 0;
        nodes.add(root);
        TreeNode temp = null;
        while (current != nodes.size()) {
            all = nodes.size();
            List<Integer> r = new ArrayList<>();
            for (int i = current; i < all; ++i) {
                temp = nodes.get(i);
                r.add(temp.val);
                if (temp.left != null)
                    nodes.add(temp.left);
                if (temp.right != null)
                    nodes.add(temp.right);
            }
            result.add(0,r);
            current = all;
        }
        return result;
    }
}
