/**
 * Created by zhongjianlv on 18-1-18.
 * <p>
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class Edit_Distance_72 {

    public int minDistance(String word1, String word2) {
        char[] w1s = word1.toCharArray();
        char[] w2s = word2.toCharArray();
        int[][] r = new int[w1s.length + 1][w2s.length + 1];
        for(int i=0; i <= w1s.length; ++i) r[i][0] = i;
        for(int i=0; i <= w2s.length; ++i) r[0][i] = i;
        int min = 0;
        int replace = 1;
        for(int i=1; i <=w1s.length; ++i)
            for(int j=1; j <= w2s.length; ++j){
                min = Math.min(r[i-1][j],r[i][j-1]) + 1;
                if(w1s[i-1] == w2s[j-1]) replace = 0;
                else replace = 1;
                min = Math.min(min,r[i-1][j-1] + replace);
                r[i][j] = min;
            }
        return r[w1s.length][w2s.length];
    }
}
