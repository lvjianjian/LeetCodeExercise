import java.util.*;

/**
 * Created by zhongjianlv on 18-1-6.
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p>
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class Substring_with_Concatenation_of_All_Words_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        int length = s.length();
        int n = words.length;
        if (n == 0)
            return result;

        int k = words[0].length();
        if (length < n * k)
            return result;

        Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }


        for (int i = 0; i < k; i++) {
            int j = i, count = 0, start = i;
            curMap.clear();
            while (j <= length - k) {
                String substring = s.substring(j, j + k);
                if (map.containsKey(substring)) {
                    curMap.put(substring, curMap.getOrDefault(substring, 0) + 1);
                    ++count;
                    while (curMap.get(substring) > map.get(substring)) {
                        String substring1 = s.substring(start, start + k);
                        curMap.put(substring1, curMap.get(substring1) - 1);
                        --count;
                        start += k;
                    }

                    if (count == n) {
                        result.add(start);
                        --count;
                        String substring1 = s.substring(start, start + k);
                        curMap.put(substring1, curMap.get(substring1) - 1);
                        start += k;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    start = j + k;
                }
                j += k;
            }
        }


        return result;
    }

    //没有考虑重复元素
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        int k = words[0].length();
        int num = words.length;
        for (int i = 0; i < k; i++) {
            for (String word : words) {
                map.put(word, -1);
            }
            int j = i;
            int temp = 0;
            while (j <= s.length() - k) {
                String substring = s.substring(j, j + k);
                if (map.containsKey(substring)) {
                    Integer integer = map.get(substring);
                    if (integer == -1 || (j - integer) > temp * k) {
                        map.put(substring, j);
                        ++temp;
                        if (temp == num) {
                            result.add(j - (temp - 1) * k);
                        }
                    } else if ((j - integer) == temp * k) {
                        result.add(integer + k);
                        map.put(substring, j);
                    } else {
                        map.put(substring, j);
                        temp = (j - integer) / k;
                    }
                } else {
                    temp = 0;
                }
                j += k;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Substring_with_Concatenation_of_All_Words_30 substring_with_concatenation_of_all_words_30 = new Substring_with_Concatenation_of_All_Words_30();
        System.out.println(substring_with_concatenation_of_all_words_30.findSubstring("barfoofoobarthefoobarman",
                new String[]{"bar", "foo", "the"}));
    }

}
