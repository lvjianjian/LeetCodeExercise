/**
 * Created by zhongjianlv on 18-2-5.
 * <p>
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class Reverse_Linked_List_II_92 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        if (head == null) return head;
        ListNode start = head;
        ListNode preStart = null;
        int k = 1;
        while (start != null && k < m) {
            preStart = start;
            start = start.next;
            ++k;
        }

        ListNode afterStart = null;
        ListNode afterAfter = null;
        afterStart = start.next;
        while (k < n) {
            if (afterStart != null) {
                afterAfter = afterStart.next;
                afterStart.next = start;
                start = afterStart;
                afterStart = afterAfter;
            }
            ++k;
        }

        if (preStart != null) {
            preStart.next.next = afterStart;
            preStart.next = start;
        } else {
            head.next = afterStart;
            head = start;
        }

        return head;
    }
}
