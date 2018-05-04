/**
 * Created by zhongjianlv on 18-1-23.
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class Remove_Duplicates_from_Sorted_List_83 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head, last = head;
        while (current != null) {
            while (current.next != null && current.next.val == current.val) {
                current = current.next;
            }
            current = current.next;
            last.next = current;
            last = current;
        }
        return head;
    }
}
