/**
 * Created by zhongjianlv on 2018/2/16
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class Palindrome_Linked_List_234 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        int n = 0;
        ListNode current = head;
        while (current != null) {
            ++n;
            current = current.next;
        }
        if (n == 2) {
            if (head.val == head.next.val) return true;
            else return false;
        } else if (n == 3) {
            if (head.val == head.next.next.val) return true;
            else return false;
        } else {
            int k = n / 2;
            int h = n % 2;
            ListNode p1, p2, p3;
            p1 = head;
            p2 = head.next;
            p3 = head.next.next;
            p1.next = null;
            while (k > 1) {
                p2.next = p1;
                p1 = p2;
                p2 = p3;
                p3 = p3.next;
                --k;
            }
            if (h == 1)
                p2 = p3;
            while (p1 != null) {
                if (p1.val != p2.val) return false;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return true;
    }

}
