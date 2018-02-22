
/**
 * Created by zhongjianlv on 18-2-6.
 * <p>
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * <p>
 * Example:
 * <p>
 * Given the sorted linked list: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Convert_Sorted_List_to_Binary_Search_Tree_109 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode s = head;
        ListNode ss = head.next;
        while (ss != tail) {
            s = s.next;
            ss = ss.next;
            if (ss != tail)
                ss = ss.next;
        }
        TreeNode temp = new TreeNode(s.val);
        temp.left = helper(head, s);
        temp.right = helper(s.next, tail);
        return temp;
    }
}
