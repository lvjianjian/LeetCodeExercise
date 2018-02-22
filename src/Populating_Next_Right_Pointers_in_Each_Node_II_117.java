/**
 * Created by zhongjianlv on 2018/2/23
 * <p>
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * <p>
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \    \
 * 4-> 5 -> 7 -> NULL
 */
public class Populating_Next_Right_Pointers_in_Each_Node_II_117 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        TreeLinkNode pre = null;
        TreeLinkNode first = root;
        TreeLinkNode now = null;
        boolean left = true;
        while (cur != null) {
            while (cur != null) {
                pre = cur.left;
                if (pre != null) {
                    first = cur;
                    break;
                }
                pre = cur.right;
                if (pre != null) {
                    first = cur;
                    left = false;
                    break;
                }
                cur = cur.next;
            }
            if (cur == null) break;
            while (cur != null) {
                if (!left) {
                    cur = cur.next;
                    left = true;
                } else {
                    now = cur.left;
                    if (now != pre && now != null) {
                        pre.next = now;
                        pre = now;
                    }
                    now = cur.right;
                    if (now != null) {
                        pre.next = now;
                        pre = now;
                    }
                    cur = cur.next;
                }
            }
            if (first.left == null)
                cur = first.right;
            else
                cur = first.left;

        }
    }


    public static void main(String[] args) {
        Populating_Next_Right_Pointers_in_Each_Node_II_117 populating_next_right_pointers_in_each_node_ii_117 = new Populating_Next_Right_Pointers_in_Each_Node_II_117();
        TreeLinkNode root = populating_next_right_pointers_in_each_node_ii_117.new TreeLinkNode(1);
        root.left = populating_next_right_pointers_in_each_node_ii_117.new TreeLinkNode(2);
        populating_next_right_pointers_in_each_node_ii_117.connect(root);
    }
}
