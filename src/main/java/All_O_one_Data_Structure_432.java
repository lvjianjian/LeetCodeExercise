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
        private String s;
        private Bucket previous;
        private Bucket next;
        private int num;
        public Bucket(){
            previous = null;
            next = null;
            s = "";
            num = 1;
        }


    }

    private Map<String, Bucket> map;
    private Bucket min;
    private Bucket max;

    /** Initialize your data structure here. */
    public All_O_one_Data_Structure_432() {
        map = new HashMap<>();
        min = new Bucket();
        max = new Bucket();
        min.next = max;
        max.previous = min;
    }


    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(map.containsKey(key)){
            Bucket bucket = map.get(key);
            bucket.num+=1;
            while(!bucket.next.s.equals("")){
                if(bucket.num > bucket.next.num){//exchange
                    String temp = bucket.s;
                    int temp_num = bucket.num;
                    bucket.num = bucket.next.num;
                    bucket.s = bucket.next.s;
                    bucket.next.num = temp_num;
                    bucket.next.s = temp;
                    map.put(bucket.s,bucket);
                    map.put(bucket.next.s,bucket.next);
                    bucket = bucket.next;
                }else{
                    break;
                }
            }
        }else{
            Bucket bucket = new Bucket();
            bucket.s = key;
            bucket.num = 1;
            bucket.next = min.next;
            min.next.previous = bucket;
            bucket.previous = min;
            min.next = bucket;
            map.put(key,bucket);
        }

    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(map.containsKey(key)){
            Bucket bucket = map.get(key);
            bucket.num -= 1;
            if(bucket.num == 0){
                bucket.previous.next = bucket.next;
                bucket.next.previous = bucket.previous;
                bucket.next = null;
                bucket.previous = null;
                map.remove(key);
            }else{
                while (!bucket.previous.s.equals("")){
                    if(bucket.previous.num > bucket.num){
                        String temp = bucket.s;
                        int temp_num = bucket.num;
                        bucket.num = bucket.previous.num;
                        bucket.s = bucket.previous.s;
                        bucket.previous.num = temp_num;
                        bucket.previous.s = temp;
                        map.put(bucket.s,bucket);
                        map.put(bucket.previous.s,bucket.previous);
                        bucket = bucket.previous;
                    }else{
                        break;
                    }
                }
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return max.previous.s;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return min.next.s;
    }

    public static void main(String[] args) {
        All_O_one_Data_Structure_432 all_o_one_data_structure_432 = new All_O_one_Data_Structure_432();
        all_o_one_data_structure_432.inc("hello");
        all_o_one_data_structure_432.inc("goodbye");
        all_o_one_data_structure_432.inc("hello");
        all_o_one_data_structure_432.inc("hello");
        System.out.println(all_o_one_data_structure_432.getMaxKey());
        all_o_one_data_structure_432.inc("leet");
        all_o_one_data_structure_432.inc("code");
        all_o_one_data_structure_432.inc("leet");
        all_o_one_data_structure_432.dec("hello");
        all_o_one_data_structure_432.inc("leet");
        all_o_one_data_structure_432.inc("code");
        all_o_one_data_structure_432.inc("code");
        System.out.println(all_o_one_data_structure_432.getMaxKey());

    }
}
