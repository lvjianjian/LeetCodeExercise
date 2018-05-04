import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-3-1.
 * <p>
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * For example:
 * Given the following binary tree,
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * You should return [1, 3, 4].
 */
public class Binary_Tree_Right_Side_View_199 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        if (root == null) return r;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        int start = 0;
        int end = 1;
        int newend;
        while (start < end) {
            r.add(nodes.get(end - 1).val);
            newend = end;
            while (start < end) {
                TreeNode n = nodes.get(start++);
                if (n.left != null) {
                    nodes.add(n.left);
                    newend++;
                }
                if (n.right != null) {
                    nodes.add(n.right);
                    newend++;
                }
            }
            end = newend;
        }
        return r;
    }
}
