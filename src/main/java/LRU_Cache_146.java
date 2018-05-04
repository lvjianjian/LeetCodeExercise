import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongjianlv on 18-3-7.
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */

public class LRU_Cache_146 {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int k, int x){
            key = k;
            val = x;
        }
    }

    private Node far;
    private Node recent;
    private Map<Integer,Node> map;
    private int c;
    public LRU_Cache_146(int capacity) {
        c = capacity;
        map = new HashMap<>();
        far = recent = new Node(0,0);
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            if(temp.next != null){
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp.prev = recent;
                recent.next = temp;
                temp.next = null;
                recent = recent.next;
            }
            return temp.val;

        }else return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            temp.val = value;
            get(key);
        }else{
            if(map.size() == c){
                Node remove = far.next;
                if(remove.next !=null)
                    remove.next.prev = far;
                far.next = far.next.next;
                map.remove(remove.key);
            }

            Node newNode =  new Node(key, value);
            map.put(key,newNode);
            recent.next = newNode;
            newNode.prev = recent;
            recent = recent.next;

        }
    }
}
