/**
 * Created by zhongjianlv on 18-4-26.
 * <p>
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 * <p>
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 * <p>
 * Return any permutation of T (as a string) that satisfies this property.
 * <p>
 * Example :
 * Input:
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 * <p>
 * <p>
 * Note:
 * <p>
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 */
public class Custom_Sort_String_791 {
    public String customSortString(String S, String T) {
        int[] temp = new int[26];
        StringBuilder res = new StringBuilder();
        for (int i = 0, length = T.length(); i < length; i++) {
            ++temp[T.charAt(i) - 'a'];
        }
        int index = 0;
        char c = 'a';
        for (int i = 0, length = S.length(); i < length; i++) {
            c = S.charAt(i);
            index = c - 'a';
            while (temp[index]-- > 0) {
                res.append(c);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (temp[i]-- > 0)
                res.append((char) (i + 'a'));
        }
        return res.toString();
    }
}
