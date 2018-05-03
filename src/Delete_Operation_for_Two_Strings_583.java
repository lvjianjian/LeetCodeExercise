/**
 * Created by zhongjianlv on 18-5-3.
 * <p>
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 * <p>
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 */
public class Delete_Operation_for_Two_Strings_583 {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        if (word1 == null) return word2.length();
        if (word2 == null) return word1.length();
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] res = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            res[i][0] = i;
        }
        for (int i = 0; i <= n2; i++) {
            res[0][i] = i;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    res[i][j] = res[i - 1][j - 1];
                else
                    res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + 1;
            }
        }

        return res[n1][n2];
    }

}
