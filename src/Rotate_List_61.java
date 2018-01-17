/**
 * Created by zhongjianlv on 18-1-17.
 * <p>
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4->5->NULL and k = 2,
 * <p>
 * return 4->5->1->2->3->NULL.
 */
public class Rotate_List_61 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            ++n;
            temp = temp.next;
        }
        temp = head;
        k %= n;
        for (int i = 0; i < k; ++i) {
            temp = temp.next;
            if (temp == null)
                temp = head;
        }
        ListNode temp2 = head;
        while (temp.next != null) {
            temp = temp.next;
            temp2 = temp2.next;
        }
        temp.next = head;
        head = temp2.next;
        temp2.next = null;
        return head;
    }

}
