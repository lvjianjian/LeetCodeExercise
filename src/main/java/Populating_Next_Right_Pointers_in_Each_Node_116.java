/**
 * Created by zhongjianlv on 2018/2/22
 * <p>
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */
public class Populating_Next_Right_Pointers_in_Each_Node_116 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }


    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) return;
        root.left.next = root.right;
        TreeLinkNode l = root.left;
        TreeLinkNode r = root.right;
        while (l.right != null) {
            l.right.next = r.left;
            l = l.right;
            r = r.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
