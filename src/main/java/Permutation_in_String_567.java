/**
 * Created by zhongjianlv on 18-4-15.
 * <p>
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * Example 1:
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * Note:
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class Permutation_in_String_567 {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) return false;
        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ++arr[s1.charAt(i) - 'a'];
        }

        int s = 0, e = 0;
        int index = 0;
        while (s < n2) {
            while (s < n2 && arr[index = s2.charAt(s) - 'a'] > 0) {
                --arr[index];
                --n1;
                ++s;
            }
            if (n1 == 0) return true;
            else if (s == n2) break;
            while (e <= s && arr[index] == 0) {
                if (e == s) {
                    ++e;
                    ++s;
                    break;
                } else {
                    ++arr[s2.charAt(e) - 'a'];
                    ++n1;
                    ++e;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Permutation_in_String_567 permutation_in_string_567 = new Permutation_in_String_567();
        System.out.println(permutation_in_string_567.checkInclusion("ab", "eidbaooo"));
    }
}
