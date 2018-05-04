/**
 * Created by zhongjianlv on 18-1-23.
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class Remove_Duplicates_from_Sorted_List_II_82 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newhead = null;
        ListNode last = null;
        while (head != null) {
            if (head.next == null || head.next.val != head.val) {
                if (last == null)
                    newhead = last = head;
                else {
                    last.next = head;
                    last = head;
                }
            } else {
                while (head.next != null && head.next.val == head.val) {
                    head = head.next;
                }
                if (head.next == null) {
                    if (last != null)
                        last.next = null;
                    else
                        return null;
                }

            }
            head = head.next;
        }
        return newhead;
    }
}
