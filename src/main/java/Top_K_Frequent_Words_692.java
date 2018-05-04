import java.util.*;

/**
 * Created by zhongjianlv on 18-3-23.
 * <p>
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * <p>
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.a
 */
public class Top_K_Frequent_Words_692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(String word:words)
            map.put(word,map.getOrDefault(word,0)+1);

        PriorityQueue<String> pq = new PriorityQueue<>(map.size(),new Comparator<String>(){
            public int compare(String s1,String s2){
                int a = map.get(s1), b = map.get(s2);
                if(a > b){
                    return 1;
                }else if(a < b){
                    return -1;
                }else{
                    return s2.compareTo(s1);
                }
            }
        });

        for(String key:map.keySet()){
            pq.add(key);
            if(pq.size() > k)
                pq.poll();
        }
        while(!pq.isEmpty())
            res.add(pq.poll());
        Collections.reverse(res);
        return res;
    }

    public List<String> topKFrequent2(String[] words, int k) {
        Map<Integer, TreeSet<String>> base_map = new HashMap<>();
        Map<String, Integer> count_map = new HashMap<>();
        int max = 0;
        for (String word : words) {
            if (!count_map.containsKey(word)) {
                count_map.put(word, 1);
                if (!base_map.containsKey(1))
                    base_map.put(1, new TreeSet<>());
                base_map.get(1).add(word);
                if (1 > max)
                    max = 1;
            } else {
                Integer count = count_map.get(word);
                base_map.get(count).remove(word);
                ++count;
                count_map.put(word, count);
                if (!base_map.containsKey(count))
                    base_map.put(count, new TreeSet<>());
                base_map.get(count).add(word);
                if (count > max) max = count;
            }
        }
        List<String> result = new ArrayList<>();
        while (k > 0) {
            TreeSet<String> strings = base_map.get(max);
            for (String string : strings) {
                result.add(string);
                k--;
                if (k == 0) return result;
            }
            max--;
        }
        return result;
    }

    public static void main(String[] args) {
        Top_K_Frequent_Words_692 top_k_frequent_words_692 = new Top_K_Frequent_Words_692();
        System.out.println(top_k_frequent_words_692.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding", "love"}, 2));

    }
}
