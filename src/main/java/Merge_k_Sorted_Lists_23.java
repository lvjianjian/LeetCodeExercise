import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhongjianlv on 17-12-28.
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class Merge_k_Sorted_Lists_23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, current = null;
        if(lists ==null || lists.length == 0)
            return head;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {
            if(node != null)
                priorityQueue.add(node);
        }


        while (priorityQueue.size() != 0){
            ListNode poll = priorityQueue.poll();
            if(current == null)
                head = current = poll;
            else {
                current.next = poll;
                current = current.next;
            }
            if(poll.next != null)
                priorityQueue.add(poll.next);
        }

        return head;
    }

    public static void main(String[] args) {
        Merge_k_Sorted_Lists_23 merge_k_sorted_lists_23 = new Merge_k_Sorted_Lists_23();
        ListNode node11 = merge_k_sorted_lists_23.new ListNode(1);
        ListNode node12 = merge_k_sorted_lists_23.new ListNode(1);
        ListNode node13 = merge_k_sorted_lists_23.new ListNode(5);
        node11.next = node12;
        node12.next = node13;


        ListNode node21 = merge_k_sorted_lists_23.new ListNode(2);
        ListNode node22 = merge_k_sorted_lists_23.new ListNode(3);
        ListNode node23 = merge_k_sorted_lists_23.new ListNode(4);
        node21.next = node22;
        node22.next = node23;

        ListNode listNode = merge_k_sorted_lists_23.mergeKLists(new ListNode[]{null});
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


}
