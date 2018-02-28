/**
 * Created by zhongjianlv on 18-2-28.
 * <p>
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * <p>
 * Return 3.
 */
public class Distinct_Subsequences_115 {
    public int numDistinct(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        if(ss.length < tt.length) return 0;
        int[][] r = new int[tt.length+1][ss.length+1];
        for(int i = 0; i <= ss.length; ++i){
            r[0][i] = 1;
        }
        for(int i = 1; i <=tt.length; ++i){
            for(int j = i;j <= ss.length; ++j){
                if(j == i){
                    if(tt[i-1] == ss[j-1]){
                        r[i][j] = r[i-1][j-1];
                    }else
                        r[i][j] = 0;
                }else{
                    if(tt[i-1] == ss[j-1]){
                        r[i][j] = r[i-1][j-1] + r[i][j-1];
                    }else{
                        r[i][j] = r[i][j-1];
                    }
                }
            }
        }
        return r[tt.length][ss.length];
    }

}
