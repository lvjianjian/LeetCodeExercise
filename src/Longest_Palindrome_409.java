/**
 * Created by zhongjianlv on 18-3-15.
 * <p>
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Longest_Palindrome_409 {
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] lower = new int[26];
        int[] supper = new int[26];
        int[] t;
        int index;
        int ji = 0;
        int r = 0;
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if (temp >= 'a') {//消协
                index = temp - 'a';
                t = lower;
            } else {//大写
                index = temp - 'A';
                t = supper;
            }

            ++t[index];
            if (t[index] == 2) {
                r += 2;
                t[index] = 0;
                --ji;
            } else {
                ++ji;
            }
        }
        if (ji > 0)
            ++r;
        return r;
    }
}
