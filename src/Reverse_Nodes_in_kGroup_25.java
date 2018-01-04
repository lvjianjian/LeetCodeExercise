/**
 * Created by zhongjianlv on 18-1-4.
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 */
public class Reverse_Nodes_in_kGroup_25 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode pre = null;
        ListNode current = head;
        ListNode current_next, current_nnext = null;
        ListNode part_head;
        while (current != null) {
            part_head = current;
            for (int i = 0; i < k - 1 && current != null; i++) {
                current = current.next;
            }
            if (current != null) {
                current = part_head;
                current_next = current.next;
                for (int i = 0; i < k - 1 && current_next != null; i++) {
                    current_nnext = current_next.next;
                    current_next.next = current;
                    current = current_next;
                    current_next = current_nnext;
                }
                if (pre == null) {
                    head = current;
                }else{
                    pre.next = current;
                }
                pre = part_head;
                part_head.next = current_nnext;
                current = current_nnext;
            }
        }
        return head;
    }
}
