import java.util.*;

/**
 * Created by zhongjianlv on 2018/5/2
 * <p>
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
 * 1
 * \
 * 2
 * /
 * 2
 * return [2].
 * <p>
 * Note: If a tree has more than one mode, you can return them in any order.
 * <p>
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class Find_Mode_in_Binary_Search_Tree_501 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Integer temp = null;
        helper(root, new int[]{0}, new int[]{-1}, res, new int[]{0});
        System.out.println(temp);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void helper(TreeNode c, int[] pre, int[] prefreq, List<Integer> res, int[] maxPre) {
        if (c == null) return;
        helper(c.left, pre, prefreq, res, maxPre);
        if (prefreq[0] != -1 && c.val == pre[0]) {
            prefreq[0] += 1;
        } else {
            pre[0] = c.val;
            prefreq[0] = 1;
        }
        if (prefreq[0] > maxPre[0]) {
            res.clear();
            maxPre[0] = prefreq[0];
            res.add(pre[0]);
        } else if (prefreq[0] == maxPre[0]) {
            res.add(pre[0]);
        }
        helper(c.right, pre, prefreq, res, maxPre);
    }

    public static void main(String[] args) {
        Find_Mode_in_Binary_Search_Tree_501 find_mode_in_binary_search_tree_501 = new Find_Mode_in_Binary_Search_Tree_501();
        System.out.println(find_mode_in_binary_search_tree_501.findMode(null));
    }
}
