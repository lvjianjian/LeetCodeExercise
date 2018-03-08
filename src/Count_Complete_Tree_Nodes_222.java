/**
 * Created by zhongjianlv on 18-3-8.
 * <p>
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class Count_Complete_Tree_Nodes_222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = 0;
        TreeNode c = root;
        while (c != null) {
            ++h;
            c = c.left;
        }

        int k = 0;
        c = root;
        int i = 1;
        while (c.left != null && c.right != null) {
            TreeNode temp = c.left;
            int j = i;
            while (j < h - 1) {
                temp = temp.right;
                ++j;
            }
            if (temp == null) {
                k = 2 * k;
                c = c.left;
            } else {
                k = 2 * k + 1;
                c = c.right;
            }
            ++i;
        }
        if (i == h) return (int) Math.pow(2, h) - 1;
        int r = (int) Math.pow(2, h - 1) - 1;
        r += 2 * k;
        if (c.left != null) {
            ++r;
        }
        return r;
    }
}

