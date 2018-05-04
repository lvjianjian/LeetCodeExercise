/**
 * Created by zhongjianlv on 2018/2/11
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Intersection_of_Two_Linked_Lists_160 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        int na = 0;
        int nb = 0;

        while(a != null){
            ++na;
            a = a.next;
        }

        while(b != null){
            ++nb;
            b = b.next;
        }

        a = headA;
        b = headB;

        if(na < nb){
            ListNode temp = a;
            a = b;
            b = temp;
            na ^= nb;
            nb ^= na;
            na ^= nb;
        }

        int j = na - nb;
        while(j != 0){
            --j;
            a = a.next;
        }

        while(a!=null){
            if(a == b) return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }
}
