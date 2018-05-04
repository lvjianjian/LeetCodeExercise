/**
 * Created by zhongjianlv on 18-3-3.
 * <p>
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class Sort_List_148 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //归并
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        return mergeSort(head,null);
    }


    private ListNode mergeSort(ListNode head,ListNode end){
        if(head.next == end){
            head.next = null;
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast !=end){
            slow = slow.next;
            fast = fast.next;
            if(fast == end) break;
            fast = fast.next;
        }
        return merge(mergeSort(head,slow),mergeSort(slow,end));
    }

    private ListNode merge(ListNode h1, ListNode h2){
        ListNode head = null;

        if(h1.val < h2.val){
            head = h1;
            h1 = h1.next;
        }else{
            head = h2;
            h2 = h2.next;
        }
        ListNode h = head;

        while(h1!=null && h2!=null){
            if(h1.val < h2.val){
                h.next = h1;
                h1 = h1.next;
            }else{
                h.next = h2;
                h2 = h2.next;
            }
            h = h.next;
        }

        while(h1!=null){
            h.next = h1;
            h1 = h1.next;
            h = h.next;
        }

        while(h2!=null){
            h.next = h2;
            h2 = h2.next;
            h = h.next;
        }
        h.next = null;
        return head;
    }


    //快排失败，最坏情况 O(n2)
    public ListNode sortList2(ListNode head) {
        if(head == null) return head;
        ListNode emptyNode =  new ListNode(0);
        emptyNode.next = head;
        quickSort(emptyNode,null);
        return emptyNode.next;
    }

    private void quickSort(ListNode head,ListNode end){
        if(head.next == end) return;
        ListNode preh = partition(head,end);
        quickSort(head, preh);
        quickSort(preh, end);
    }

    private ListNode partition(ListNode preh, ListNode poste){
        ListNode temp = preh.next;
        preh.next = temp.next;
        ListNode next = preh;
        while(next.next != poste){
            if(next.next.val < temp.val && preh != next){
                ListNode temp2 = next.next;
                next.next = next.next.next;
                temp2.next = preh.next;
                preh.next = temp2;
                preh = preh.next;
            }else {
                if(next.next.val < temp.val && preh == next) preh = preh.next;
                next = next.next;
            }
        }
        temp.next = preh.next;
        preh.next = temp;
        return temp;
    }
}
