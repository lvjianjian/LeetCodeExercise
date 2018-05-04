/**
 * Created by zhongjianlv on 2018/2/17
 * <p>
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class Delete_Node_in_a_Linked_List_237 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        ListNode n1 = node.next;
        if(n1 != null){
            node.val = n1.val;
            node.next = n1.next;
        }
    }

}