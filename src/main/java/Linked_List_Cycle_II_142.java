
/**
 * Created by zhongjianlv on 17-12-24.
 */
public class Linked_List_Cycle_II_142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast != slow) {
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            slow = slow.next;
        }

        if (fast == null) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


}
