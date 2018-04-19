/**
 * Created by zhongjianlv on 18-4-19.
 * <p>
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * Input:
 * <p>
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 */
public class Longest_Palindromic_Subsequence_516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }
        int end, cmax;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                end = j + i;
                if (i == 1) {
                    if (s.charAt(j) == s.charAt(end)) {
                        res[j][end] = 2;
                    } else res[j][end] = 1;
                } else {
                    cmax = Math.max(res[j + 1][end], res[j][end - 1]);
                    if (s.charAt(j) == s.charAt(end))
                        cmax = Math.max(res[j + 1][end - 1] + 2, cmax);
                    res[j][end] = cmax;
                }
            }
        }
        return res[0][n - 1];
    }
}
