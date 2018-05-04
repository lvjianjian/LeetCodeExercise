import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongjianlv on 18-3-15.
 * <p>
 * Implement a MapSum class with insert, and sum methods.
 * <p>
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
 * <p>
 * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
 * <p>
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */
public class Map_Sum_Pairs_677 {
    class TrieNode {
        TrieNode[] next;
        int sum;

        TrieNode() {
            next = new TrieNode[26];
            sum = 0;
        }
    }

    TrieNode root;
    Map<String, Integer> map;

    public Map_Sum_Pairs_677() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int update = val;
        if (map.containsKey(key)) {
            update = val - map.get(key);
        }
        map.put(key, val);
        TrieNode cn = root;
        for (char c : key.toCharArray()) {
            if (cn.next[c - 'a'] == null) {
                cn.next[c - 'a'] = new TrieNode();
            }
            cn = cn.next[c - 'a'];
            cn.sum += update;
        }

    }

    public int sum(String prefix) {
        TrieNode cn = root;
        for (char c : prefix.toCharArray()) {
            if (cn.next[c - 'a'] == null) return 0;
            cn = cn.next[c - 'a'];
        }
        return cn.sum;
    }

    public static void main(String[] args) {
        Map_Sum_Pairs_677 map_sum_pairs_677 = new Map_Sum_Pairs_677();
        map_sum_pairs_677.insert("aa", 3);
        map_sum_pairs_677.insert("aa", 2);
    }
}
