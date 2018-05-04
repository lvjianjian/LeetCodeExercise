/**
 * Created by zhongjianlv on 2018/2/14
 * Reverse a singly linked list.
 */
public class Reverse_Linked_List_206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p1,p2,p3;
        p1 = head;
        p2 = head.next;
        p3 = head.next.next;
        p1.next = null;
        while(p2 != null){
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            if(p2 != null)
                p3 = p2.next;
        }
        return p1;
    }
}
