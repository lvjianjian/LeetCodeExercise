import java.util.Stack;

/**
 * Created by zhongjianlv on 18-3-1.
 * <p>
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class Reorder_List_143 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode h = head;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int n = stack.size();
        ListNode pop = null;
        while (n > 1 && h != pop) {
            n -= 2;
            pop = stack.pop();
            pop.next = h.next;
            h.next = pop;
            h = pop.next;
        }
        h.next = null;
    }
}
