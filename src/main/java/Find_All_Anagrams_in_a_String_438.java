import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-5-5.
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Find_All_Anagrams_in_a_String_438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>(100);
        int p_length = p.length();
        int s_length = s.length();
        if (s == null || p_length > s_length) return res;
        int[] count = new int[26];
        int record = 0;
        int index;
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        for (int i = 0; i < p_length; i++) {
            index = pp[i] - 'a';
            record = change(count, record, index, true);
            index = ss[i] - 'a';
            record = change(count, record, index, false);
        }
        int j = p_length;
        while (j <= s_length) {
            if (record == 0)
                res.add(j - p_length);
            if (j == s_length) break;
            index = ss[j] - 'a';
            record = change(count, record, index, false);
            index = ss[j++ - p_length] - 'a';
            record = change(count, record, index, true);
        }

        return res;
    }

    private int change(int[] count, int record, int index, boolean add) {
        if (add) {
            count[index]++;
        } else {
            count[index]--;
        }
        if (count[index] != 0)
            record |= (1 << index);
        else
            record &= ~(1 << index);
        return record;
    }
}
