import java.util.List;

/**
 * Created by zhongjianlv on 18-3-25.
 * <p>
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class Odd_Even_Linked_List_328 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode evenHead = head.next;
        ListNode oddTemp = head;
        ListNode evenTemp = head.next;

        while (oddTemp.next != null) {
            oddTemp.next = evenTemp.next;
            if (oddTemp.next != null)
                evenTemp.next = oddTemp.next.next;
            else
                evenTemp.next = null;
            if (evenTemp.next == null)
                break;
            oddTemp = oddTemp.next;
            evenTemp = evenTemp.next;
        }
        if (oddTemp.next != null)
            oddTemp = oddTemp.next;
        oddTemp.next = evenHead;
        return head;
    }
}
