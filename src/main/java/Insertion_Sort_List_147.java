/**
 * Created by zhongjianlv on 18-3-3.
 * <p>
 * Sort a linked list using insertion sort.
 */
public class Insertion_Sort_List_147 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode next = head;
        while (next.next != null) {
            ListNode preh = null;
            ListNode h = head;
            while (h != next.next && next.next.val > h.val) {
                preh = h;
                h = h.next;
            }
            if (h != next.next) {
                ListNode temp = next.next;
                next.next = next.next.next;
                temp.next = h;
                if (h == head) {
                    head = temp;
                } else {
                    preh.next = temp;
                }
            } else next = next.next;

        }
        return head;
    }
}
