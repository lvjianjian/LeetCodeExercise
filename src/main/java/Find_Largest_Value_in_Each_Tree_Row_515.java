import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-4-3.
 * <p>
 * You need to find the largest value in each row of a binary tree.
 * <p>
 * Example:
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * Output: [1, 3, 9]
 */
public class Find_Largest_Value_in_Each_Tree_Row_515 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        List<TreeNode> l = new ArrayList<>(30);
        if (root == null) return res;
        l.add(root);
        int start = 0;
        int end = 1;
        int max = 0;
        while (start < end) {
            max = Integer.MIN_VALUE;
            while (start < end) {
                TreeNode treeNode = l.get(start);
                if(treeNode.val > max)
                    max = treeNode.val;
                if(treeNode.left!=null)
                    l.add(treeNode.left);
                if(treeNode.right != null)
                    l.add(treeNode.right);
                ++start;
            }
            res.add(max);
            end = l.size();
        }
        return res;
    }
}
