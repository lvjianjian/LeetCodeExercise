/**
 * Created by zhongjianlv on 2018/2/16
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * For example, given the following matrix:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 */
public class Maximal_Square_221 {

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;
        if(m == 0) return 0;
        int max = 0;
        int[][] r = new int[n][m];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(matrix[i][j] == '0') {
                    r[i][j] = 0;
                }else{
                    if(i-1 < 0 || i-1 >=n || j-1 < 0 || j-1 >= m || r[i-1][j-1] == 0)
                        r[i][j] = 1;
                    else{
                        int k = r[i-1][j-1];
                        int l = 1;
                        for(; l <= k; ++l){
                            if(matrix[i-l][j] == '0' || matrix[i][j-l] == '0'){
                                break;
                            }
                        }
                        r[i][j] = l;
                    }
                    if(r[i][j] * r[i][j] > max)
                        max = r[i][j] * r[i][j];
                }
            }
        }
        return max;
    }
}
