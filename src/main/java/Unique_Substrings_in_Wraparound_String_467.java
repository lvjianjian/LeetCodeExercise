/**
 * Created by zhongjianlv on 18-4-8.
 * <p>
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * <p>
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
 * <p>
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 * <p>
 * Example 1:
 * Input: "a"
 * Output: 1
 * <p>
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * Example 2:
 * Input: "cac"
 * Output: 2
 * Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 * Example 3:
 * Input: "zab"
 * Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 */
public class Unique_Substrings_in_Wraparound_String_467 {
    public int findSubstringInWraproundString(String p) {
        int r = 0;
        int pre = 0;
        int[] temp = new int[26];
        char[] chars = p.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (i == 0) {
                r += 1;
                temp[index] = 1;
                pre = 1;
            } else {
                if ((chars[i] - 'a') == (chars[i - 1] - 'a' + 1) % 26) {
                    ++pre;
                } else {
                    pre = 1;
                }
                if (temp[index] < pre) {
                    r += pre - temp[index];
                    temp[index] = pre;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Unique_Substrings_in_Wraparound_String_467 unique_substrings_in_wraparound_string_467 = new Unique_Substrings_in_Wraparound_String_467();
        System.out.println(unique_substrings_in_wraparound_string_467.findSubstringInWraproundString("zabce"));
    }
}
