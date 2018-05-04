/**
 * Created by zhongjianlv on 18-3-13.
 */
public class Perfect_Squares_279 {
    public int numSquares(int n) {
        int[] r = new int[n + 1];
        r[0] = 1;
        for(int i = 1; i <= n ;++i){
            int k = (int)Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <=k; ++j){
                int temp = r[j*j] + r[i - j*j];
                if(temp < min) min = temp;
            }
            r[i] = min;
        }
        return r[n];
    }
}
