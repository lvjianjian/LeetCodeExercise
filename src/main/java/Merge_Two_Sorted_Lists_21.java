import java.util.Arrays;

/**
 * Created by zhongjianlv on 17-12-28.
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists
 */
public class Merge_Two_Sorted_Lists_21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode current, head = null;

        if (l1 != null)
            if (l2 != null)
                if (l1.val < l2.val) {
                    current = head = l1;
                    l1 = l1.next;
                } else {
                    current = head = l2;
                    l2 = l2.next;
                }
            else
                return l1;
        else if (l2 != null)
            return l2;
        else
            return null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            current.next = l1;
        } else
            current.next = l2;
        return head;
    }

    public static void main(String[] args) {
        Merge_Two_Sorted_Lists_21 merge_two_sorted_lists_21 = new Merge_Two_Sorted_Lists_21();
        ListNode node11 = merge_two_sorted_lists_21.new ListNode(1);
        ListNode node12 = merge_two_sorted_lists_21.new ListNode(1);
//        ListNode node13 = merge_two_sorted_lists_21.new ListNode(5);
        node11.next = node12;
//        node12.next = node13;


        ListNode node21 = merge_two_sorted_lists_21.new ListNode(2);
        ListNode node22 = merge_two_sorted_lists_21.new ListNode(3);
        ListNode node23 = merge_two_sorted_lists_21.new ListNode(4);
        node21.next = node22;
        node22.next = node23;

        ListNode listNode = merge_two_sorted_lists_21.mergeTwoLists(node11, node21);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}


