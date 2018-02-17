import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 2018/2/17
 * <p>
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * For example, given the following binary tree:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p>
 * ["1->2->5", "1->3"]
 */
public class Binary_Tree_Paths_257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        List<Integer> c = new ArrayList<>();
        helper(root, c, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> c, List<String> result) {
        if (node == null) return;
        c.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(c.get(0));
            for (int k = 1; k < c.size(); ++k) {
                sb.append("->" + c.get(k));
            }
            result.add(sb.toString());
        } else {
            helper(node.left, c, result);
            helper(node.right, c, result);
        }
        c.remove(c.size() - 1);
    }
}
