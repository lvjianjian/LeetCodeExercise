/**
 * Created by zhongjianlv on 18-1-4.
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Swap_Nodes_in_Pairs_24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            if (current.next != null) {
                ListNode nnext = current.next.next;
                if (pre != null) {
                    pre.next = current.next;
                }else {
                    head = current.next;
                }
                current.next.next = current;
                current.next = nnext;
                pre = current;
                current = nnext;
            }else {
                break;
            }
        }
        return head;
    }
}
