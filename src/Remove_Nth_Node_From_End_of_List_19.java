/**
 * Created by zhongjianlv on 18-1-5.
 */
public class Remove_Nth_Node_From_End_of_List_19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode next = head;
        for (int i = 0; i < n; i++) {
            if(next == null)
                next = head;
            next = next.next;
        }
        if(next == null){
            return first.next;
        }

        while (next.next != null){
            head = head.next;
            next = next.next;
        }

        head.next = head.next.next;
        return first;
    }
}
