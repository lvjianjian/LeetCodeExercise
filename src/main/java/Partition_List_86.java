/**
 * Created by zhongjianlv on 18-2-1.
 * <p>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class Partition_List_86 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode first = head;
        ListNode first_pre = null;
        while (first != null && first.val < x) {
            first_pre = first;
            first = first.next;

        }
        if (first == null) return head;
        ListNode next = first.next;
        ListNode pre = first;
        while (next != null) {
            while (next != null && next.val >= x) {
                pre = next;
                next = next.next;
            }
            if (next == null)
                return head;
            pre.next = next.next;
            next.next = first;
            if (first_pre != null)
                first_pre.next = next;
            else
                head = next;
            first_pre = next;
            next = pre.next;
        }
        return head;
    }
}
