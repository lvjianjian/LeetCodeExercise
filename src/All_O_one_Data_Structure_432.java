import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhongjianlv on 2018/2/8
 * <p>
 * Implement a data structure supporting the following operations:
 * <p>
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 */
public class All_O_one_Data_Structure_432 {

    class Bucket{
        private Set<String> set;
        private Bucket previous;
        private Bucket next;
        public Bucket(){
            previous = null;
            next = null;
            set = new HashSet<>();
        }

        private void remove(String key){
            this.set.remove(key);
            if(this.set.size() == 0){
                this.previous.next = this.next;
                this.next.previous = this.previous;
            }
        }
    }

    private Map<String, Integer> integerMap;
    private Map<Integer, Bucket> bucketMap;
    private Bucket min;
    private Bucket max;

    /** Initialize your data structure here. */
    public All_O_one_Data_Structure_432() {
        integerMap = new HashMap<>();
        bucketMap = new HashMap<>();
        min = new Bucket();
        max = new Bucket();
        min.next = max;
        max.previous = min;
    }


    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int num = integerMap.getOrDefault(key, 0);
        if(num != 0) {
            Bucket bucket = bucketMap.get(num);
            bucket.remove(key);
        }
        num += 1;
        integerMap.put(key, num);
        Bucket temp = bucketMap.getOrDefault(num, new Bucket());
        temp.set.add(key);
        if(temp.set.size() == 1){
            temp.next = min.next;
            temp.previous = min;
            temp.next.previous = temp;
            min.next = temp;
        }else{

        }

    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
         int num = integerMap.getOrDefault(key, 0);
         if(num != 0){
             Bucket bucket = bucketMap.get(num);
             bucket.remove(key);
             num -= 1;
             integerMap.replace(key, num);
             if(num > 0){
                 Bucket temp = bucketMap.getOrDefault(num, new Bucket());
                 temp.set.add(key);
                 if(temp.set.size() == 1){
                     temp.next = min.next;
                     temp.previous = min;
                     temp.next.previous = temp;
                     min.next = temp;
                 }
             }
         }

    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(integerMap.size()==0) return "";
        return max.previous.set.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(integerMap.size() == 0) return "";
        return min.next.set.iterator().next();
    }
}
