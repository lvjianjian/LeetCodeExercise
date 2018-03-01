import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongjianlv on 18-3-1.
 * <p>
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 */
public class Copy_List_with_Random_Pointer_138 {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    Map<RandomListNode, RandomListNode> map = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode copy = new RandomListNode(head.label);
        map.put(head, copy);
        if (!map.containsKey(head.next))
            copy.next = copyRandomList(head.next);
        else
            copy.next = map.get(head.next);
        if (!map.containsKey(head.random))
            copy.random = copyRandomList(head.random);
        else copy.random = map.get(head.random);
        return copy;
    }

}
