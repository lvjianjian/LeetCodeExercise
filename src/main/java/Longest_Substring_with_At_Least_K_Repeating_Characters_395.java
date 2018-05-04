import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-4-28.
 * <p>
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "aaabb", k = 3
 * <p>
 * Output:
 * 3
 * <p>
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * <p>
 * Input:
 * s = "ababbc", k = 2
 * <p>
 * Output:
 * 5
 * <p>
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class Longest_Substring_with_At_Least_K_Repeating_Characters_395 {

    public int longestSubstring(String s, int k) {
        if (s == null) return 0;
        int n = s.length();
        if (n == 0 || n < k) return 0;
        if (k == 1) return n;
        return helper(s.toCharArray(), 0, n, k);
    }

    private int helper(char[] s, int left, int right, int k) {
        if (left >= right) return 0;
        int[] count = new int[26];
        int res = 0;
        for (int i = left; i < right; i++) {
            ++count[s[i] - 'a'];
        }
        boolean flag = false;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] < k) {
                flag = true;
                break;
            }
        }
        if (!flag) return right - left;
        int j;
        for (int i = left; i < right; i++) {
            j = i;
            while (j < right && count[s[j]-'a'] >= k) {
                ++j;
            }
            res = Math.max(res, helper(s, i, j, k));
        }
        return res;
    }

    //slow
    public int longestSubstring2(String s, int k) {
        if (s == null) return 0;
        int n = s.length();
        if (n == 0 || n < k) return 0;
        if (k == 1) return n;
        int[] count;
        int temp = 0;
        int res = -1;
        int index = 0;
        int maxIndex = 0;
        int j;
        while (index + res < n) {
            temp = 0;
            count = new int[26];
            for (int i = index; i < n; i++) {
                j = s.charAt(i) - 'a';
                ++count[j];
                //judge 是否满足条件
                if (count[j] >= k) {//对应位置置为0
                    temp &= ~(1 << j);
                } else {//不满足，对应位置设置为1
                    temp |= (1 << j);
                }
                if (temp == 0 && i - index > res) {
                    res = i - index;
                    maxIndex = i;
                }
            }
            if (index == maxIndex)
                index = maxIndex = maxIndex + 1;
            else
                index = maxIndex = maxIndex + 2;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        Longest_Substring_with_At_Least_K_Repeating_Characters_395 longest_substring_with_at_least_k_repeating_characters_395 = new Longest_Substring_with_At_Least_K_Repeating_Characters_395();
        System.out.println(longest_substring_with_at_least_k_repeating_characters_395.longestSubstring("aaabb", 3));
    }
}
